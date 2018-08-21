/**
 *  Clase de modelo que representa un horario para una determinada pelicula.
 */
package net.itinajero.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clubes")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String nombreClub; 


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

}
