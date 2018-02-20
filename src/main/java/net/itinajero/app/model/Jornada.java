
/**
 *  Clase de modelo que representa un horario para una determinada pelicula.
 */
package net.itinajero.app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jornadas")
public class Jornada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private Date fechaFin;
	private Date fechaInicio;
	private int numeroJornada;
	 
	/**
	 * Constructor sin parametros
	 */
	public Jornada() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Jornada [id=" + id + ", fechaInicio=" + fechaInicio 
				 + "]";
	}

	public int getNumeroJornada() {
		return numeroJornada;
	}

	public void setNumeroJornada(int numeroJornada) {
		this.numeroJornada = numeroJornada;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
