package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Jornada;
import net.itinajero.app.service.IJornadasService;

@Controller
@RequestMapping(value="/jornadas")
public class JornadasController {
	
	@Autowired
	private IJornadasService serviceJornadas;
	
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model model){
		
		List<Jornada> lista = serviceJornadas.buscarTodas();
		model.addAttribute("jornadas",lista);
		return "jornadas/listJornadas";
	}
	
	/**
	 * Metodo que muestra la lista de jornadas con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Jornada> lista = serviceJornadas.buscarTodas(page);
		model.addAttribute("jornadas", lista);
		return "jornadas/listJornadas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Jornada jornada) {
		return "jornadas/formJornada";
	}	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Jornada jornada, BindingResult result, Model model,
			  RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "jornadas/formJornada";
		}	
				    	
		serviceJornadas.insertar(jornada);
		attributes.addFlashAttribute("msg", "Los datos de la jornada fueron guardados!");
			
		return "redirect:/jornadas/indexPaginate";		
	}		
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idJornada, Model model) {		
		Jornada jornada = serviceJornadas.buscarPorId(idJornada);			
		model.addAttribute("jornada", jornada);
		return "jornadas/formJornada";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idJornada, RedirectAttributes attributes) {
		// Eliminamos el registro del Banner
		serviceJornadas.eliminar(idJornada);
		attributes.addFlashAttribute("msg", "La Jornada fue eliminado!.");
		return "redirect:/jornadas/indexPaginate";
	}		
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	
	
	
}
