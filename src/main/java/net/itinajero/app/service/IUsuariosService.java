package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Usuario;

public interface IUsuariosService {

	//UserDetails loadUserByUsername(String username);

	//List<Partido> buscarPorJornada(int id);
		
	List<Usuario> buscarTodas();
	//List<String> buscarFechas();

	Page<Usuario> buscarTodas(Pageable page);

}
