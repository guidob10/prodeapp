package net.itinajero.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuariosRepository;


// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class UsuariosServiceJPA implements IUsuariosService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
     @Autowired
 	private UsuariosRepository usuariosRepo;

	@Override
	public List<Usuario> buscarTodas() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();	
	}
    
	@Override
	public Page<Usuario> buscarTodas(Pageable page) {
		return usuariosRepo.findAll(page);
	}	
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
}
