package net.itinajero.app.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Partido;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
	Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
	crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface PartidosRepository extends JpaRepository<Partido, Integer> {

	// Listado de peliculas filtradas por estatus
	 //public List<Jornada> findByEstatus_OrderByTitulo(String estatus);
 //	public List<Partido> findByJornada(int jornada);
	public List<Partido> findByJornada_Id(int idJornada);
	public Partido findById(int idPartido);

}
