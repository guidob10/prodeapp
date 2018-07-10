package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Ranking;
import net.itinajero.app.model.Usuario;



public interface IRankingsService {

	
	//List<Apuesta> buscarPorJornada(int id);
	//List<Apuesta> buscarPorPartidos(List<Partido> partidos, Usuario usuario);
		
	List<Ranking> buscarTodas();
		

}
