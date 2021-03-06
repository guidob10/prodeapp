package net.itinajero.app.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Jornada;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
	Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
	crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface JornadasRepository extends JpaRepository<Jornada, Integer> {

	public List<Jornada> findByFechaInicioEquals(Date fechaInicio);
	public List<Jornada> findByFechaFinGreaterThan(Date fechaInicio);

}
