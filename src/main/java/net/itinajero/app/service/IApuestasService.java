package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;



public interface IApuestasService {

	
	//List<Apuesta> buscarPorJornada(int id);

	void insertar(Apuesta apuesta);

	List<Apuesta> buscarPorPartidos(List<Partido> partidos);
	
		
//	List<Apuesta> buscarTodas();
	//List<String> buscarFechas();

}
