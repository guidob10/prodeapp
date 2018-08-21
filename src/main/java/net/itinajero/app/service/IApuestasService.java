package net.itinajero.app.service;

import java.util.List;
import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;

public interface IApuestasService {

	void insertar(Apuesta apuesta);

	List<Apuesta> buscarPorPartidos(List<Partido> partidos, Usuario usuario);

}
