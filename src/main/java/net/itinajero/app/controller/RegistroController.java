package net.itinajero.app.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.UsuariosPerfilServiceJPA;
import net.itinajero.app.service.UsuariosServiceJPA;

@Controller
@RequestMapping(value="/registro")
public class RegistroController {

	@Autowired
	public UsuariosServiceJPA servicioUsuario;
	
	@Autowired
	public UsuariosPerfilServiceJPA servicioUsuarioPerfil;	
	
	@RequestMapping(value="/registrar",method = RequestMethod.GET)
	public String	mostrarRegistro(HttpServletRequest request,HttpServletResponse response, Model model){

	 	model.addAttribute("usuarionuevo", new Usuario());
		return "formRegistro";
	}

	
	@RequestMapping(value = "/registroProceso", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("usuarionuevo") Usuario usuario) throws NoSuchAlgorithmException {
		  servicioUsuario.insertar(usuario);

		  servicioUsuarioPerfil.insertar(usuario);
		  
	  return new ModelAndView("bienvenidaRegistro", "nombre", usuario.getNombre());

	  }	
}
