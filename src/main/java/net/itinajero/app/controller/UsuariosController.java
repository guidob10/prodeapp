package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Club;
import net.itinajero.app.model.Jornada;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;
import net.itinajero.app.service.IUsuariosPerfilService;
import net.itinajero.app.service.IUsuariosService;


@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	//Roles de usuario
	@Autowired
	private IUsuariosPerfilService serviceUsuariosPerfil;	
	

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
	//	List<Apuesta> lista = serviceApuestas.buscarTodas();
		List<Usuario> lista = serviceUsuarios.buscarTodas();
		model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Usuario> lista = serviceUsuarios.buscarTodas(page);
		model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}	
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuarioform) {
		return "usuarios/formUsuario";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idUsuario, Model model) {		
		Usuario usuario = serviceUsuarios.buscarPorId(idUsuario);			
		model.addAttribute("usuarioform", usuario);
		return "usuarios/formUsuario";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		// Eliminamos el registro del Banner
		serviceUsuarios.eliminar(idUsuario);
		attributes.addFlashAttribute("msg", "El partido fue eliminado!.");
		return "redirect:/usuarios/index";
	}		
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Usuario usuarioform, BindingResult result, Model model,
			  RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "usuarios/formUsuario";
		}	
				    	
		serviceUsuarios.insertar(usuarioform);
		attributes.addFlashAttribute("msg", "Los datos de Usuario fueron guardados!");
			
		return "redirect:/usuarios/index";		
	}	
	
	@ModelAttribute("roles")
	public List<UsuarioPerfil> getPerfiles(){
		return serviceUsuariosPerfil.buscarTodas();
	}		
	

}
