package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPartidosService {

	List<Partido> buscarPorJornada(int id);
	
	List<Partido> buscarTodas();
	Page<Partido> buscarTodas(Pageable page);

	void eliminar(int idPartido);

	void insertar(Partido partido);
	Partido buscarPorId(int idPartido);	 

}
