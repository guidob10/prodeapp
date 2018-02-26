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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * Metodo que muestra la lista de peliculas con paginacion
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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	
	
	
}
