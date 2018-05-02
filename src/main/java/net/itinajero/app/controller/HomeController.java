package net.itinajero.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
import net.itinajero.app.util.Utileria;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class HomeController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IBannersService serviceBannners;
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IJornadasService serviceJornadas;
	
	@Autowired
	private IPartidosService servicePartidos;	
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IHorariosService serviceHorarios;	
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private INoticiasService serviceNoticias;
	
	@Autowired
	private IParametrosService serviceParametros;	
	
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
			//List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);	
			List<String> listaFechas  = serviceJornadas.buscarFechas();
			Jornada jornada = serviceJornadas.buscarPorFechaReciente();
			List<Partido> partidos = servicePartidos.buscarPorJornada(jornada.getId());
			
			//List<String> listaFechass = Utileria.getNextDays(4);
			
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		 //	 model.addAttribute("peliculas", peliculas);
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
		  //	List<String> listaFechass = Utileria.getNextDays(4);
		//	List<Pelicula> peliculas  = servicePeliculas.buscarPorFecha(fechaSinHora);
		//	peliculas = null;
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
	 * Metodo para ver los detalles y horarios de una pelicula
	 * @param idPelicula
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}/{fecha}")
	public String mostrarDetalle(@PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha, Model model) {
		// TODO - Buscar en la base de datos los horarios.		
		List<Horario> horarios= serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));		
		return "detalle";
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
	/*
	@RequestMapping(value="/downloadPdf")
    public ResponseEntity<InputStreamResource> downloadPdf()
    {
        try
        {
            File file = new File("C:\Users\GuidoB\\Desktop\\programacion\\sts-bundle\\workspaceprode\\prodeapp\\src\\main\\resources\\jasperreports\\rptTest_1524882993650.pdf");
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentLength(file.length());
            respHeaders.setContentDispositionFormData("attachment", file.getName());
            InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
        }
        catch (Exception e)
        {
            String message = "Errore nel download del file "+idForm+".csv; "+e.getMessage();
            logger.error(message, e);
            return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
	
	
	@RequestMapping(value="/report")
    @ResponseBody
    public ResponseEntity<byte[]> verReporte(Model model,@RequestParam(name = "format",defaultValue = "pdf",required = false) String format) throws FileNotFoundException {    

		List<Parametro> listaParametro  = serviceParametros.buscarTodas();
		List<Jornada> listaJornada = serviceJornadas.buscarTodas();
		Parametro parametro = listaParametro.get(0);
		
		RptProde unReporte = new RptProde();
		
		unReporte.setDs(new JRBeanCollectionDataSource(listaJornada));
		unReporte.setTitulo("Home");
		
		if(unReporte.generar("rptTest",null,"pdf",parametro.getValor())){
			// C:\Users\GuidoB\Desktop\programacion\sts-bundle\workspaceprode\prodeapp\src\main\resources\jasperreports\rptTest_1523240431050.pdf
			String ruta = Reporte.extraerRutaReportes();

		    Path path = Paths.get(ruta + File.separator + "rptTest_1525141030566.pdf");
		    byte[] pdfContents = null;
		    try {
		        pdfContents = Files.readAllBytes(path);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }			
		   // File file = new File(ruta + File.separator + "rptTest_1523240431050.pdf");
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    String filename = "rptTest_1525141030566.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
		            pdfContents, headers, HttpStatus.OK);
		    return response;		    
		    

		}
		 else{

			 ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(null, null, HttpStatus.FORBIDDEN);
			 //return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
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
	
	
	
	/**
	 * Metodo para personalizar el Data Binding para los atributos de tipo Date
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {				
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
