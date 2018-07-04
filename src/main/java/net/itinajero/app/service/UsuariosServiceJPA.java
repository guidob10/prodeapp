package net.itinajero.app.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Jornada;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuariosRepository;


// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class UsuariosServiceJPA implements IUsuariosService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
     @Autowired
 	private UsuariosRepository usuariosRepo;
     
   //  @Autowired
   //  PasswordEncoder passwordEncoder;     

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
	
	@Override
	public Usuario buscarDatosPerfil(String username) throws Exception{
		Usuario usuario = usuariosRepo.findByUsername(username);
		//if (usuario == null) {
		//	throw new Exception(username);
		//}
		
		return (usuario);
	}

	@Override
	public void eliminar(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);	
		
	}

	@Override
	public void insertar(Usuario usuario) throws NoSuchAlgorithmException {
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		String original = usuario.getPassword();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}	
		usuario.setPassword(sb.toString());
		usuario.setActivo(false);
		usuariosRepo.save(usuario);
		
	}
	
	@Override
	public void editar(Usuario usuario) throws NoSuchAlgorithmException {
		/*
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		String original = usuario.getPassword();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}	
		usuario.setPassword(sb.toString());
		usuario.setActivo(false);
		*/
		usuariosRepo.save(usuario);
		
	}	

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		//return usuariosRepo.findById(idUsuario);
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if (optional.isPresent())
			return optional.get();
		return null;		
	}
}
