package net.itinajero.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Apuesta;
import net.itinajero.app.model.Partido;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
	Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
	crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface ApuestasRepository extends JpaRepository<Apuesta, Integer> {

	// ver como traer por array		
	public Apuesta findByPartido_Id(int idPartido);
	
	public Apuesta findByPartido_IdAndUsuario_Id(int idPartido, int idUsuario);
	
	

}
