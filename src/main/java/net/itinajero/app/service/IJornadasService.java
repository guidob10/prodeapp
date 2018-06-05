package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Jornada;


public interface IJornadasService {
	
 	
	List<Jornada> buscarTodas();
	List<String> buscarFechas();
	Jornada buscarPorFechaReciente();
	Jornada buscarPorFecha(Date fecha);
	Page<Jornada> buscarTodas(Pageable page);
	void insertar(Jornada jornada);
	Jornada buscarPorId(int idJornada);
	void eliminar(int idJornada);
	/*
	Jornada buscarPorId(int idJornada);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
    List<Jornada> buscarActivas();	
	List<Jornada> buscarPorFecha(Date fecha);
	Page<Jornada> buscarTodas(Pageable page);	
	
	*/
}
