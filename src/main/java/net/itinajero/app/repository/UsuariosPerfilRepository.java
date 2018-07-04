package net.itinajero.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.model.UsuarioPerfil;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
	Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
	crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface UsuariosPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {

	Usuario findByUsername(String username);

		//Usuario findByUsername(String username);
	

}
