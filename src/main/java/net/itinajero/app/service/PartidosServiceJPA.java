package net.itinajero.app.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Partido;
import net.itinajero.app.repository.PartidosRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class PartidosServiceJPA implements IPartidosService {
	

    // Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
	private PartidosRepository partidosRepo;
	 
	@Override
	public void insertar(Partido partido) {
		partidosRepo.save(partido);
	}

	 
	@Override
	public void eliminar(int idPartido) {
		partidosRepo.deleteById(idPartido);	
	}

	
	@Override
	public List<Partido> buscarPorJornada(int idJornada){
		
		List<Partido> partidos = partidosRepo.findByJornada_Id(idJornada); 
		return partidos;
				 		
	}
	
	@Override
	public List<Partido> buscarTodas() {
		return partidosRepo.findAll();		
	}


	@Override
	public Page<Partido> buscarTodas(Pageable page) {
		return partidosRepo.findAll(page);
	}


	@Override
	public Partido buscarPorId(int idPartido) {
		// TODO Auto-generated method stub
		return partidosRepo.findById(idPartido);
	}
}
