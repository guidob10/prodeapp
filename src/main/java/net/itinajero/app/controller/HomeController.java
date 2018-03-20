package net.itinajero.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import net.itinajero.app.model.*;
import net.itinajero.app.service.*;
import net.itinajero.app.util.Utileria;

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
	/*
	@Override
	protected void configure (HttpSecurity http) throws Exception {
	    http.csrf().disable();
	}*/	
	
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
	
	 
	@RequestMapping(value="/report")
    @ResponseBody
//    public void verReporte(HttpServletResponse response) throws JRException, IOException {
    public String verReporte(Model model,@RequestParam(name = "format",defaultValue = "pdf",required = false) String format) {
 
		//JasperReport report = JasperCompileManager.compileReport("C:\\informes JAsper\\JRXML\\InformeMySql.jrxml");
		
		//Reporte unReporte = new Reporte("rptTestB.jrxml");
		RptProde unReporte = new RptProde();			
		if(unReporte.generar("rptTest",null,"pdf"))
			return "ok";
		else
			return "mal";
				
		
		//response.setStatus( HttpServletResponse.SC_BAD_REQUEST  ); si error
		
     //   model.addAttribute("format", format);
     //   model.addAttribute("datasource", serviceJornadas.buscarTodas());
     //   model.addAttribute("AUTOR", "Tutor de programacion");

       // return "customer_report";
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
