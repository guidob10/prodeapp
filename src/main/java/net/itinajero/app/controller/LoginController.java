package net.itinajero.app.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IUsuariosService;

@Controller
@RequestMapping(value="/admin")
public class LoginController {
	
	
	@Autowired
	private IUsuariosService serviceUsuarios;	
	
	/**
	 * Metodo que muestra la pantalla de bienvenida cuando un usuario registrado ingresa
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value="/index")
	public String mostrarPrincipalAdmin(HttpSession session, Principal principal) throws Exception{
		/**
		 * Hacemos un CAST de la interfaz java.security.Principal al tipo GenericPrincipal, que es una 
		 * implementacion propia de Apache Tomcat (Realm). De esta forma, podemos tener acceso a los roles que tiene
		 * el usuario que hizo Login, para poder mostrar el menu segun el ROL.
		 * 
		 */					
		if (session.getAttribute("usuario") == null) {		
			GenericPrincipal generic  = (GenericPrincipal) principal;
			// Agregamos a la session el objeto de tipo GenericPrincipal.
			session.setAttribute("usuario", generic); 
			
		}
		// Si usuario no activo cierro sesion.
		Usuario usuario  = serviceUsuarios.buscarDatosPerfil(principal.getName()); 
		if (usuario.getActivo().booleanValue() == false ){
			session.invalidate();
			return "redirect:/";
		}
		 
		return "admin";		
	}

	
	/**
	 * Metodo para cerrar sesion
	 * @param request
	 * @return
	 */
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request){
		 HttpSession sesion=request.getSession();
		 sesion.invalidate();
		 return "redirect:/";
	}
}
