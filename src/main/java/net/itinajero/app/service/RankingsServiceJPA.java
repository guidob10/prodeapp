package net.itinajero.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.itinajero.app.model.Ranking;
import net.itinajero.app.repository.RankingsRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class RankingsServiceJPA implements IRankingsService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private RankingsRepository rankingsRepo;

	@Override
	public List<Ranking> buscarTodas() {
		// TODO Auto-generated method stub
		return rankingsRepo.findAll();
	}		 

}
