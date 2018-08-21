package net.itinajero.app.service;

 
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Jornada;
import net.itinajero.app.repository.JornadasRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class JornadasServiceJPA implements IJornadasService {
	
    // Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
	private JornadasRepository jornadasRepo;
	 
	@Override
	public void insertar(Jornada jornada) {
		jornadasRepo.save(jornada);
	}

	@Override
	public List<Jornada> buscarTodas() {
		return jornadasRepo.findAll();		
	}
	
	@Override
	public Jornada buscarPorId(int idJornada) {	
		Optional<Jornada> optional = jornadasRepo.findById(idJornada);
		if (optional.isPresent())
			return optional.get();
		return null;
	}	
	
	@Override
	public void eliminar(int idJornada) {
		jornadasRepo.deleteById(idJornada);
	}	

	@Override
	public Page<Jornada> buscarTodas(Pageable page) {
		return jornadasRepo.findAll(page);
	}
	 
	@Override
	public List<String> buscarFechas() {
		// TODO Auto-generated method stub
		List<Jornada> jornadas = jornadasRepo.findAll();
		List<String> fechas = new ArrayList<String>();
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");

		for (Jornada j : jornadas) {
			String s = formatter.format(j.getFechaInicio());
			fechas.add(s);
		}		

		return fechas;
		
	}
	
	@Override
	public Jornada buscarPorFechaReciente(){
		
		Date fecha = new Date();
		//si fecha del dia mayor a ultima jornada da error.
		List<Jornada> jornadas = jornadasRepo.findByFechaFinGreaterThan(fecha); 
		return jornadas.get(0);
				 
		
	}
	
	@Override
	public Jornada buscarPorFecha(Date fecha){
		
		List<Jornada> jornadas = jornadasRepo.findByFechaInicioEquals(fecha); 
		return jornadas.get(0);
				 
		
	}	
	 
}
