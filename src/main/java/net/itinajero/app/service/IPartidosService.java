package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPartidosService {

	List<Partido> buscarPorJornada(int id);
	
	//void insertar(Jornada jornada);	
	List<Partido> buscarTodas();
	Page<Partido> buscarTodas(Pageable page);
	//List<String> buscarFechas();
	//Jornada buscarPorFechaReciente();

	void eliminar(int idPartido);
	 
	/*
	Jornada buscarPorId(int idJornada);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
    List<Jornada> buscarActivas();	
	List<Jornada> buscarPorFecha(Date fecha);
		
	void eliminar(int idJornada);
	*/
}
