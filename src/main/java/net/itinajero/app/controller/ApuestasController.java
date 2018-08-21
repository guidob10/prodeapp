package net.itinajero.app.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.formsentity.ApuestaForm;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IApuestasService;
import net.itinajero.app.service.IParametrosService;
import net.itinajero.app.service.IPartidosService;
import net.itinajero.app.service.IUsuariosService;


@Controller
@RequestMapping(value="/apuestas")
public class ApuestasController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private IApuestasService serviceApuestas;

    @Autowired
 	private IPartidosService servicePartidos; 
        
	@Autowired
	private IUsuariosService serviceUsuarios;	    
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idJornada, Model model, Principal user) throws Exception {	
		List<Apuesta> apuestas;
		ApuestaForm apuestaForm = new ApuestaForm();

		List<Partido> partidos = servicePartidos.buscarPorJornada(idJornada);
		//buscar apuesta por usuario jornada, si no existe, crear primera.
		
		Usuario usuario  = serviceUsuarios.buscarDatosPerfil(user.getName());
		
		apuestas = serviceApuestas.buscarPorPartidos(partidos, usuario);		
		
	 	if (apuestas == null || apuestas.isEmpty()){		

			for (Partido partido : partidos) {
				Apuesta apuesta = new Apuesta();
				apuesta.setPartido(partido);
				apuestas.add(apuesta);
			}
		}
		
		apuestaForm.setApuestas(apuestas);		

		model.addAttribute("apuestaForm", apuestaForm);
		return "apuestas/listApuestas";
	}    
    	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute ApuestaForm apuestaForm, BindingResult result, Model model,
			RedirectAttributes attributes, Principal user) throws Exception {	
		System.out.println(apuestaForm);
		System.out.println(apuestaForm.getApuestas());
		List<Apuesta> apuestas = apuestaForm.getApuestas();

// Recupera usuario 
		Usuario usuario  = serviceUsuarios.buscarDatosPerfil(user.getName());
		Date todayDate = new Date();
		for (Apuesta apuesta : apuestas){
			apuesta.setUsuario(usuario);
			//valido que partido sea anterior a dia de la fecha
			if (apuesta.getPartido().getFechaPartido().before((todayDate))){
				serviceApuestas.insertar(apuesta);
			}
		}				
		
		attributes.addFlashAttribute("msg", "Apuesta Realizada!");
		return "redirect:/jornadas/indexPaginate?page=0";	
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	

}
