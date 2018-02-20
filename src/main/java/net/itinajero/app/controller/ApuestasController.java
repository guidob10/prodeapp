package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.formsentity.ApuestaForm;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IApuestasService;
import net.itinajero.app.service.IPartidosService;
import net.itinajero.app.util.Utileria;


@Controller
@RequestMapping(value="/apuestas")
public class ApuestasController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private IApuestasService serviceApuestas;

    @Autowired
 	private IPartidosService servicePartidos;    
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idJornada, Model model) {	
		
		List<Partido> partidos = servicePartidos.buscarPorJornada(idJornada);	
	//	Apuesta apuesta = serviceApuestas.buscarPorJornada(idJornada);			
	//	model.addAttribute("apuesta", apuesta);
		model.addAttribute("partidos", partidos);
		return "apuestas/listApuestas";
	}    
    
    
/*
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
	//	List<Apuesta> lista = serviceApuestas.buscarTodas();
		List<Apuesta> lista = null;
		model.addAttribute("apuestas", lista);
		return "apuestas/listApuestas";
	}
	*/	
	
	//@PostMapping(value = "/save")
	//public String guardar(BindingResult result, Model model,
	//		@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request, RedirectAttributes attributes) {
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public String guardar(@RequestParam Apuesta[] apuestas, Model model) {	
	//public String procesaForm(BusquedaOfertas bo, Model modelo) {
		 
	//	if (result.hasErrors()){
			
	//		System.out.println("Existieron errores");
	//		return "apuestas/listApuestas";
	//	}
	 
		System.out.println("Existieron"+ apuestas);

		// Primero insertamos el detalle
	    serviceDetalles.insertar(pelicula.getDetalle());
	    
		// Como el Detalle ya tiene id, ya podemos guardar la pelicula
		servicePeliculas.insertar(pelicula);
		attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
		
		//return "redirect:/peliculas/index";
		return "redirect:/jornadas/mostrarIndexPaginado";		
	}
				
	*/
	
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String guardar(@ModelAttribute("apuestaForm") ApuestaForm apuestaForm) {
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute ApuestaForm apuestaForm, BindingResult result, Model model,
			 HttpServletRequest request,RedirectAttributes attributes) {	
		System.out.println(apuestaForm);
		System.out.println(apuestaForm.getApuestas());
		List<Apuesta> apuestas = apuestaForm.getApuestas();
		
		/*
		if(null != apuestas && apuestas.size() > 0) {
			ApuestasController.apuestas = apuestas;
			for (Apuesta apuestas : apuestas) {
				System.out.printf("%s \t %s \n", apuestas.getFirstname(), apuestas.getLastname());
			}
		}
		*/
		// return new ModelAndView("show_contact", "contactForm", contactForm);
		return "redirect:/jornadas/mostrarIndexPaginado";	
	}	


}
