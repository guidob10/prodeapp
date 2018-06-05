package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Club;
import net.itinajero.app.model.Jornada;
import net.itinajero.app.model.Partido;
import net.itinajero.app.service.IClubesService;
import net.itinajero.app.service.IJornadasService;
import net.itinajero.app.service.IPartidosService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping(value="/partidos")
public class PartidosController {
	
	@Autowired
	private IPartidosService servicePartidos;
	
	@Autowired
	private IClubesService serviceClubes;	
	
	@Autowired
	private IJornadasService serviceJornadas;	
		 
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Partido> lista = servicePartidos.buscarTodas();
		model.addAttribute("partidos", lista);
		return "partidos/listPartidos";
	}
	
	/**
	 * Metodo que muestra la lista con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Partido> lista = servicePartidos.buscarTodas(page);
		model.addAttribute("partidos", lista);
		return "partidos/listPartidos";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Partido partido) {
		return "partidos/formPartido";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idPartido, Model model) {		
		Partido partido = servicePartidos.buscarPorId(idPartido);			
		model.addAttribute("partido", partido);
		return "partidos/formPartido";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPartido, RedirectAttributes attributes) {
		// Eliminamos el registro del Banner
		servicePartidos.eliminar(idPartido);
		attributes.addFlashAttribute("msg", "El partido fue eliminado!.");
		return "redirect:/partidos/indexPaginate";
	}	
	
	@ModelAttribute("clubes")
	public List<Club> getClubes(){
		return serviceClubes.buscarClubes();
	}	
	
	@ModelAttribute("jornadas")
	public List<Jornada> getJornadas(){
		return serviceJornadas.buscarTodas();
	}	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Partido partido, BindingResult result, Model model,
			  RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "partidos/formPartido";
		}	
				    	
		servicePartidos.insertar(partido);
		attributes.addFlashAttribute("msg", "Los datos del partido fueron guardados!");
			
		return "redirect:/partidos/indexPaginate";		
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	
	
}
