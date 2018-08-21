package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import net.itinajero.app.model.Ranking;
import net.itinajero.app.service.IApuestasService;
import net.itinajero.app.service.IPartidosService;
import net.itinajero.app.service.IRankingsService;
import net.itinajero.app.service.IUsuariosService;


@Controller
@RequestMapping(value="/rankings")
public class RankingsController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private IApuestasService serviceApuestas;

    @Autowired
 	private IPartidosService servicePartidos; 
    
	@Autowired
	private IUsuariosService serviceUsuarios;	  
	
	@Autowired
	private IRankingsService serviceRankings;	
	

	// Metodo que muestra la lista de noticias
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Ranking> listaRank = serviceRankings.buscarTodas();
		model.addAttribute("rankings", listaRank);
		return "rankings/listRankings";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	

}
