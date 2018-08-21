package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;
import net.itinajero.app.repository.UsuariosPerfilRepository;


// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class UsuariosPerfilServiceJPA implements IUsuariosPerfilService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
     @Autowired
 	private UsuariosPerfilRepository usuariosPerfilRepo;

	@Override
	public List<UsuarioPerfil> buscarTodas() {
		// Nota: Esta lista podria ser obtenida de una BD
		List<UsuarioPerfil> perfiles = new LinkedList<>();
		perfiles = usuariosPerfilRepo.findAll(); 
				
		return perfiles;
	}	


	@Override
	public void eliminar(int idUsuario) {
		usuariosPerfilRepo.deleteById(idUsuario);	
		
	}

	@Override
	public void insertar(Usuario usuario) {
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setUsername(usuario.getUsername());
		usuarioPerfil.setPerfil("jugador");
		
		usuariosPerfilRepo.save(usuarioPerfil);
		// TODO Auto-generated method stub
		
	}
}
