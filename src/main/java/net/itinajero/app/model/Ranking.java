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
@Table(name = "Rankings")
public class Ranking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
 
	@ManyToOne
	@JoinColumn(name = "idUsuario") // foreignKey en la tabla de Peliculas
	private Usuario usuario;
	
	private Integer puntos;

	@ManyToOne
	@JoinColumn(name = "idJornada") // foreignKey en la tabla de Peliculas
	private Jornada jornada;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
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
	public Ranking() {

	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}	

}



