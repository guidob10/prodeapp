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

@Entity
@Table(name = "Apuestas")
public class Apuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private boolean ganador;
	 
	// Relacion Muchos a Uno -> Muchos apuestas para una partido
	@ManyToOne
	@JoinColumn(name = "idPartido") // foreignKey 
	private Partido partido;		
 
	 
	@ManyToOne
	@JoinColumn(name = "idUsuario") // foreignKey en la tabla de Peliculas
	private Usuario usuario;	 	
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}
	 
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
  
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
  
	/**
	 * Constructor sin parametros
	 */
	public Apuesta() {

	}	

}



