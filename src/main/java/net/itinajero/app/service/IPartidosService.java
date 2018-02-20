package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Pelicula;


public interface IPartidosService {

	List<Partido> buscarPorJornada(int id);
	
	//void insertar(Jornada jornada);	
	//List<Jornada> buscarTodas();
	//List<String> buscarFechas();
	//Jornada buscarPorFechaReciente();
	 
	/*
	Jornada buscarPorId(int idJornada);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
    List<Jornada> buscarActivas();	
	List<Jornada> buscarPorFecha(Date fecha);
	Page<Jornada> buscarTodas(Pageable page);	
	void eliminar(int idJornada);
	*/
}
