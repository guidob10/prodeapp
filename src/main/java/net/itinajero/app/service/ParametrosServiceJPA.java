package net.itinajero.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Parametro;
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

}
