package net.itnajero.app.accesodatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccesoDB {

	private static EntityManager unEntityManager; 
	private static AccesoDB unAccesoDB = null; 
	
	public static EntityManager obtenerInstancia(String parametro){

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(parametro);
		unEntityManager = entityManagerFactory.createEntityManager();
		
		return unEntityManager;
	}

}
