package net.itinajero.app.service;

 
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Club;
import net.itinajero.app.model.Jornada;
import net.itinajero.app.repository.ClubesRepository;
import net.itinajero.app.repository.JornadasRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class ClubesServiceJPA implements IClubesService {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext.
 //   @Autowired	
//	private HorariosRepository horariosRepo;
	
    // Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
	private ClubesRepository clubesRepo;
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
    /*
	@Override
	public List<Jornada> buscarTodas() {
		return jornadasRepo.findAll();		
	}
	*/
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

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}
	

	@Override
	public List<String> buscarGeneros() {
		
		// Nota: Esta lista podria ser obtenida de una BD
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		generos.add("Thriller");
				
		return generos;
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
		List<Jornada> jornadas = jornadasRepo.findByFechaInicioGreaterThan(fecha); 
		return jornadas.get(0);
				 
		
	}
	 */

	@Override
	public List<Club> buscarClubes() {
		// Nota: Esta lista podria ser obtenida de una BD
		List<Club> clubes = new LinkedList<>();
		clubes = clubesRepo.findAll(); 
/*
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
 */
				
		return clubes;
	}
}
