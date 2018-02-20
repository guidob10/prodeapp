package net.itinajero.app.service;

 
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 //   @Autowired	
//	private HorariosRepository horariosRepo;
	
    // Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
	private JornadasRepository jornadasRepo;
	/*
	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarPorFecha(Date fecha) {		
		List<Pelicula> peliculas = null;
		// Buscamos en la tabla de horarios, [agrupando por idPelicula]
		List<Horario> horarios = horariosRepo.findByFecha(fecha);
		peliculas = new LinkedList<>();

		// Formamos la lista final de Peliculas que regresaremos.
		for (Horario h : horarios) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			peliculas.add(h.getPelicula());
		}		
		return peliculas;
	}
*/
	@Override
	public List<Jornada> buscarTodas() {
		return jornadasRepo.findAll();		
	}
/*
	@Override
	public List<Pelicula> buscarActivas() {
		List<Pelicula> peliculas = null;
		peliculas = peliculasRepo.findByEstatus_OrderByTitulo("Activa");
		return peliculas;
	}

		
	@Override
	public Pelicula buscarPorId(int idPelicula) {	
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void eliminar(int idPelicula) {
		//peliculasRepo.delete(idPelicula); // Spring 4.3
		peliculasRepo.deleteById(idPelicula);
		
	}
*/
	@Override
	public Page<Jornada> buscarTodas(Pageable page) {
		return jornadasRepo.findAll(page);
	}
	
	
	//recupero fechas de fixture
	 
	@Override
	public List<String> buscarFechas() {
		// TODO Auto-generated method stub
		List<Jornada> jornadas = jornadasRepo.findAll();
		List<String> fechas = new ArrayList<String>();
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Formamos la lista final de Peliculas que regresaremos.
		for (Jornada j : jornadas) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
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
