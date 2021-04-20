/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Oferta")
public class Oferta implements Serializable {
	public Oferta() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_OFERTA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_OFERTA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="PrecioOferta", nullable=false)	
	private double precioOferta;
	
	@Column(name="FechaCaducidadOferta", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaCaducidadOferta;
	
	@Column(name="Activada", nullable=false, length=1)	
	private boolean activada;
	
	@OneToOne(mappedBy="pertenece_a_", targetEntity=basededatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Producto contiene;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPrecioOferta(double value) {
		this.precioOferta = value;
	}
	
	public double getPrecioOferta() {
		return precioOferta;
	}
	
	public void setFechaCaducidadOferta(java.util.Date value) {
		this.fechaCaducidadOferta = value;
	}
	
	public java.util.Date getFechaCaducidadOferta() {
		return fechaCaducidadOferta;
	}
	
	public void setActivada(boolean value) {
		this.activada = value;
	}
	
	public boolean getActivada() {
		return activada;
	}
	
	public void setContiene(basededatos.Producto value) {
		if (this.contiene != value) {
			basededatos.Producto lcontiene = this.contiene;
			this.contiene = value;
			if (value != null) {
				contiene.setPertenece_a_(this);
			}
			if (lcontiene != null && lcontiene.getPertenece_a_() == this) {
				lcontiene.setPertenece_a_(null);
			}
		}
	}
	
	public basededatos.Producto getContiene() {
		return contiene;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
