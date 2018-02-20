package net.itinajero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Jornada;
import net.itinajero.app.service.IJornadasService;
import net.itinajero.app.service.IPartidosService;

@Controller
@RequestMapping(value="/partidos")
public class PartidosController {
	
	@Autowired
	private IPartidosService servicePartidos;
	
	/*
	@GetMapping(value="/index")
	public String mostrarIndex(Model model){
		
		List<Jornada> lista = servicePartidos.buscarTodas();
		model.addAttribute("jornadas",lista);
		return "jornadas/listJornadas";
	}*/
	
}
