package net.itinajero.app.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;

public interface IUsuariosService {

	List<Usuario> buscarTodas();

	Page<Usuario> buscarTodas(Pageable page);
	
	void eliminar(int idUsuario);
	void insertar(Usuario idUsuario) throws NoSuchAlgorithmException;
	void editar(Usuario idUsuario) throws NoSuchAlgorithmException;
	Usuario buscarPorId(int idUsuario);	 	

	Usuario buscarDatosPerfil(String username) throws Exception;
	
}
