package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Club;
import net.itinajero.app.model.Jornada;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;
import net.itinajero.app.repository.UsuariosPerfilRepository;
import net.itinajero.app.repository.UsuariosRepository;


// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class UsuariosPerfilServiceJPA implements IUsuariosPerfilService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
     @Autowired
 	private UsuariosPerfilRepository usuariosPerfilRepo;
/*
	@Override
	public List<UsuarioPerfil> buscarTodas() {
		// TODO Auto-generated method stub
		return usuariosPerfilRepo.findAll();	
	}
	*/
	@Override
	public List<UsuarioPerfil> buscarTodas() {
		// Nota: Esta lista podria ser obtenida de una BD
		List<UsuarioPerfil> perfiles = new LinkedList<>();
		perfiles = usuariosPerfilRepo.findAll(); 
/*
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
 */
				
		return perfiles;
	}	
    /*
	@Override
	public Page<UsuarioPerfil> buscarTodas(Pageable page) {
		return usuariosPerfilRepo.findAll(page);
	}	
	*/
      /*
    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuariosRepo.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(usuario);
    }
    */
	/*
	@Override
	public Usuario buscarDatosPerfil(String username) throws Exception{
		Usuario usuario = usuariosPerfilRepo.findByUsername(username);
		//if (usuario == null) {
		//	throw new Exception(username);
		//}
		
		return (usuario);
	}
	*/

	@Override
	public void eliminar(int idUsuario) {
		usuariosPerfilRepo.deleteById(idUsuario);	
		
	}
/*
	@Override
	public void insertar(UsuarioPerfil usuario) {
		usuariosPerfilRepo.save(usuario);
		
	}
	*/
/*
	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		//return usuariosRepo.findById(idUsuario);
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if (optional.isPresent())
			return optional.get();
		return null;		
	}
	*/
	@Override
	public void insertar(Usuario usuario) {
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setUsername(usuario.getUsername());
		usuarioPerfil.setPerfil("jugador");
		
		usuariosPerfilRepo.save(usuarioPerfil);
		// TODO Auto-generated method stub
		
	}
}
