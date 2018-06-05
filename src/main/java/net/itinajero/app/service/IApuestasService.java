package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;



public interface IApuestasService {

	
	//List<Apuesta> buscarPorJornada(int id);

	void insertar(Apuesta apuesta);

	List<Apuesta> buscarPorPartidos(List<Partido> partidos, Usuario usuario);
	
		
//	List<Apuesta> buscarTodas();
	//List<String> buscarFechas();

}
