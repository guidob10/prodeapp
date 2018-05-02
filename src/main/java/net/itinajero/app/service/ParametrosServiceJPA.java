package net.itinajero.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Parametro;
import net.itinajero.app.model.Partido;
import net.itinajero.app.repository.ApuestasRepository;
import net.itinajero.app.repository.ParametrosRepository;

@Service
public class ParametrosServiceJPA implements IParametrosService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private ParametrosRepository parametrosRepo;
    
    
	@Override
	public List<Parametro> buscarTodas() {
		return parametrosRepo.findAll();		
	}    
		 /*
	@Override
	public void insertar(Apuesta apuesta) {
		apuestasRepo.save(apuesta);
	}
	*/
	 /*
	@Override
	public List<Apuesta> buscarPorJornada(int idJornada){
		
		//Date fecha = new Date();
		List<Apuesta> apuestas = apuestasRepo.findByJornada_Id(idJornada); 
		return apuestas;
				 		
	}*/
/*
	@Override
	public List<Apuesta> buscarPorPartidos(List<Partido> partidos) {		
		List<Apuesta> apuestas = new ArrayList<Apuesta>();
		
		for (Partido partido : partidos) {
			Apuesta apuesta = apuestasRepo.findByPartido_Id(partido.getId());
			if (apuesta != null){
				apuestas.add(apuesta);
			}
		}
		return apuestas;
	}*/
	 
/*
	@Override
	public void eliminar(int idApuesta) {
		// detallesRepo.delete(idDetalle); // Spring 4.3
		apuestasRepo.deleteById(idApuesta);
	}
*/


}
