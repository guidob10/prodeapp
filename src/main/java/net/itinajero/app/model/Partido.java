
/**
 *  Clase de modelo que representa un horario para una determinada pelicula.
 */
package net.itinajero.app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Partidos")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private Date fechaPartido;
	private int puntosLocal;
	private int puntosVisita;

	// Relacion Muchos a Uno -> Muchas jornadas para un partido
	@ManyToOne
	@JoinColumn(name = "idJornada") // foreignKey 
	private Jornada jornada;
	
	// Relacion Muchos a Uno -> Muchos clubes para una partido
	@ManyToOne
	@JoinColumn(name = "idLocal") // foreignKey 
	private Club local;	
	
	// Relacion Muchos a Uno -> Muchos clubes para una partido
	@ManyToOne
	@JoinColumn(name = "idVisita") // foreignKey 
	private Club visita;		
	
	 
	/**
	 * Constructor sin parametros
	 */
	public Partido() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}


	public int getPuntosLocal() {
		return puntosLocal;
	}

	public void setPuntosLocal(int puntosLocal) {
		this.puntosLocal = puntosLocal;
	}

	public int getPuntosVisita() {
		return puntosVisita;
	}

	public void setPuntosVisita(int puntosVisita) {
		this.puntosVisita = puntosVisita;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Club getLocal() {
		return local;
	}

	public void setLocal(Club local) {
		this.local = local;
	}

	public Club getVisita() {
		return visita;
	}

	public void setVisita(Club visita) {
		this.visita = visita;
	}	
/*
	@Override
	public String toString() {
		return "Horario [id=" + id + ", fechaPartido=" + fechaPartido + ", puntosLocal=" + puntosLocal
				+ ", pelicula=" + pelicula + "]";
	}
*/
}
