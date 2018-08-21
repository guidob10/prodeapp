package net.itinajero.app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// Manejo de roles se hace por archivo web.xml, por lo que quizas definir
// la clase no es lo mejor.
@Entity
@Table(name = "UsuarioPerfil")
public class UsuarioPerfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String perfil;
	
//	@OneToOne
	private String username;			 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Constructor sin parametros
	 */
	public UsuarioPerfil() {

	}	

}



