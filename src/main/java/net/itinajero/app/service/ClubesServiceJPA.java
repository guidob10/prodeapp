package net.itinajero.app.service;

 
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Club;
import net.itinajero.app.repository.ClubesRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class ClubesServiceJPA implements IClubesService {
	

    // Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
	private ClubesRepository clubesRepo;

	@Override
	public List<Club> buscarClubes() {

		List<Club> clubes = new LinkedList<>();
		clubes = clubesRepo.findAll(); 
				
		return clubes;
	}
}
