package net.itinajero.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.ApuestasRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class ApuestasServiceJPA implements IApuestasService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private ApuestasRepository apuestasRepo;
		 
	@Override
	public void insertar(Apuesta apuesta) {
		apuestasRepo.save(apuesta);
	}


	@Override
	public List<Apuesta> buscarPorPartidos(List<Partido> partidos, Usuario usuario) {	
		
		List<Apuesta> apuestas = new ArrayList<Apuesta>();
		
		for (Partido partido : partidos) {
			Apuesta apuesta = apuestasRepo.findByPartido_IdAndUsuario_Id(partido.getId(), usuario.getId());
			if (apuesta != null){
				apuestas.add(apuesta);
			}
		}
		return apuestas;
	}
	 


}
