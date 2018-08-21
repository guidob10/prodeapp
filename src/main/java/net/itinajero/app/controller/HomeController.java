package net.itinajero.app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import net.itinajero.app.model.*;
import net.itinajero.app.service.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class HomeController {
	
	private final static Logger log = Logger.getLogger(HomeController.class);
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IBannersService serviceBannners;
	
	@Autowired
	private IJornadasService serviceJornadas;
	
	@Autowired
	private IPartidosService servicePartidos;	
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@Autowired
	private IParametrosService serviceParametros;
	
	@Autowired
	private IUsuariosService serviceUsuarios;		
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Metodo para mostrar la pagina principal de la aplicacion
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {	

		try {
		    Date fechaSinHora = dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas  = serviceJornadas.buscarFechas();
			Jornada jornada = serviceJornadas.buscarPorFechaReciente();
			List<Partido> partidos = servicePartidos.buscarPorJornada(jornada.getId());
			log.warn("Home Controller inicio");

			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("partidos",partidos);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		return "home";

	}
	/**
	 * Metodo para filtrar las peliculas por fecha
	 * @param fecha
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {		
		try {			
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));

			List<String> listaFechas  = serviceJornadas.buscarFechas();
			Jornada jornada = serviceJornadas.buscarPorFecha(fecha);
			List<Partido> partidos = servicePartidos.buscarPorJornada(jornada.getId());
			model.addAttribute("fechas", listaFechas);			
			// Regresamos la fecha que selecciono el usuario con el mismo formato
			model.addAttribute("fechaBusqueda",dateFormat.format(fecha));			
			model.addAttribute("partidos", partidos);			
			return "home";
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}

	/**
	 * Metodo que muestra la vista de la pagina de Acerca
	 * @return
	 */
	@RequestMapping(value = "/about")
	public String mostrarAcerca() {			
		return "acerca";
	}
	
	@RequestMapping(value="/formLogin", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "formLogin";
	}
		
	@RequestMapping(value="/report")
    @ResponseBody
    public ResponseEntity<byte[]> verReporte(Model model,@RequestParam(name = "format",defaultValue = "pdf",required = false) String format) throws FileNotFoundException {    

		List<Parametro> listaParametro  = serviceParametros.buscarTodas();
		List<Jornada> listaJornada = serviceJornadas.buscarTodas();
		Parametro parametro = listaParametro.get(0);
		
		RptProde unReporte = new RptProde();
		
		unReporte.setDs(new JRBeanCollectionDataSource(listaJornada));
		unReporte.setTitulo("Home");
		
		if(unReporte.generar("rptFecha",null,format,parametro.getValor())){
			// C:\Users\GuidoB\Desktop\programacion\sts-bundle\workspaceprode\prodeapp\src\main\resources\jasperreports\rptTest_1523240431050.pdf
			String ruta = Reporte.extraerRutaReportes();
			
		    //Path path = Paths.get(ruta + File.separator + "rptFecha_1525141721766.pdf");
			Path path = Paths.get(ruta + File.separator + unReporte.getSalida());
		    byte[] pdfContents = null;
		    try {
		        pdfContents = Files.readAllBytes(path);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }			

		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    String filename = unReporte.getSalida();
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
		            pdfContents, headers, HttpStatus.OK);
		    return response;		    
		    

		}
		 else{
			 // retorna error
			 ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(null, null, HttpStatus.FORBIDDEN);
			 return response;	
		 }

	}

	
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBannners.buscarActivos();
	}
	
	
	@RequestMapping(value = "/perfil/{nombreusuario}")
	public String mostrarUsuario(@PathVariable("nombreusuario") String nombreUsuario, Model model) throws Exception {
		// TODO - Buscar en la base de datos el usuario.		
		Usuario usuarioPerfil  = serviceUsuarios.buscarDatosPerfil(nombreUsuario);
		if (usuarioPerfil == null)
			return "perfilInexistente";
		else{
			model.addAttribute("nombre", usuarioPerfil.getNombre());
			model.addAttribute("email", usuarioPerfil.getEmail());	
		return "perfil";
		}
	}	
	
	
	
	/**
	 * Metodo para personalizar el Data Binding para los atributos de tipo Date
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {				
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
