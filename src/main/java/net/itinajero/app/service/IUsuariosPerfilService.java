package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;

public interface IUsuariosPerfilService {
		
	List<UsuarioPerfil> buscarTodas();
	
	void eliminar(int idUsuarioPerfil);
	void insertar(Usuario idUsuarioPerfil);

}
