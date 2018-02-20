package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.repository.UsuariosRepository;


// Registramos esta clase como un Bean en nuestro Root ApplicationContext.
@Service
public class UsuariosServiceJPA implements IUsuariosService{

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
     @Autowired
 	private UsuariosRepository usuariosRepo;
		/*
	@Override
	public void insertar(Apuesta apuesta) {
		apuestasRepo.save(apuesta);
	}

	@Override
	public void eliminar(int idApuesta) {
		// detallesRepo.delete(idDetalle); // Spring 4.3
		apuestasRepo.deleteById(idApuesta);
	}
*/
}
