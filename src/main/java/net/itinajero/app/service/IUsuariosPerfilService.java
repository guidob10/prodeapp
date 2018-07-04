package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;

public interface IUsuariosPerfilService {

	//UserDetails loadUserByUsername(String username);

	//List<Partido> buscarPorJornada(int id);
		
	List<UsuarioPerfil> buscarTodas();
	//List<String> buscarFechas();

	//Page<Usuario> buscarTodas(Pageable page);
	
	void eliminar(int idUsuarioPerfil);
	void insertar(Usuario idUsuarioPerfil);
	//Usuario buscarPorId(int idUsuario);	 	

	//Usuario buscarDatosPerfil(String username) throws Exception;

}
