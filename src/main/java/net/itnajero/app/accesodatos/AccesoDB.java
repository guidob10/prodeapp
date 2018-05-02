package net.itnajero.app.accesodatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccesoDB {

	private static EntityManager unEntityManager; 
	private static AccesoDB unAccesoDB = null; 
	//private static SessionFactory sessions;
	//private static AnnotationConfiguration  cfg;
//	private 	   Transaction 	  tx;
//	private ObjetoTransaccion[] transactList = new ObjetoTransaccion[1000];
//	private String[] transactListHql = new String[1000];
//	private String[] transactListSql = new String[1000];
//	public static final String OPERACION_GUARDAR = "guardar";
//	public static final String OPERACION_BORRAR = "borrar";
//	public static final String OPERACION_MERGE = "merge";	
	
	
	public static EntityManager obtenerInstancia(String parametro){
	//	if (unAccesoDB == null){
	//		unAccesoDB = new AccesoDB();
	//	}
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(parametro);
		unEntityManager = entityManagerFactory.createEntityManager();
		
		return unEntityManager;
	}

	
	/*
	private AccesoDB(){		

		try {	
			cfg = new AnnotationConfiguration();
			cfg.configure();
			cfg.setProperty("org.hibernate.envers.default_schema", "esigaauditoria");
			cfg.setProperty("org.hibernate.envers.revision_on_collection_change", "false");
			cfg.setProperty("org.hibernate.envers.store_data_at_delete", "true");
			sessions = cfg.buildSessionFactory();	
		} catch (Exception e) {
			System.out.println("Init AccesoDB");
			System.out.println(e.getMessage());
		}
	}	
	*/
}
