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
@Table(name = "Clubes")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String nombreClub; 

/*
	// Relacion Muchos a Uno -> Muchos horarios para una pelicula
	@ManyToOne
	@JoinColumn(name = "idPelicula") // foreignKey en la tabla de Horarios
	private Pelicula pelicula;
*/
	/**
	 * Constructor sin parametros
	 */
	public Club() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}


	/*
	@Override
	public String toString() {
		return "Horario [id=" + id + ", fechaPartido=" + fechaPartido + ", puntosLocal=" + puntosLocal
				+ ", pelicula=" + pelicula + "]";
	}*/

}
