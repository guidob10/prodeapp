package net.itinajero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Jornada;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IJornadasService;
import net.itinajero.app.service.IPartidosService;

@Controller
@RequestMapping(value="/partidos")
public class PartidosController {
	
	@Autowired
	private IPartidosService servicePartidos;
	
	 
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Partido> lista = servicePartidos.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "partidos/listPartidos";
	}
	
	/**
	 * Metodo que muestra la lista de peliculas con paginacion
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
	
}
