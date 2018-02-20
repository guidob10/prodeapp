package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IUsuariosService;


@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IUsuariosService serviceUsuarios;
	
/*
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
	//	List<Apuesta> lista = serviceApuestas.buscarTodas();
		List<Apuesta> lista = null;
		model.addAttribute("apuestas", lista);
		return "apuestas/listApuestas";
	}
	*/	

}
