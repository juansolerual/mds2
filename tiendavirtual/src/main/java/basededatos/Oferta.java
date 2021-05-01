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
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_OFERTA_CONTIENE) {
			return ORM_contiene;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
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
	
	@Column(name="NombreOferta", nullable=true, length=255)	
	private String nombreOferta;
	
	@Column(name="PorcentajeOferta", nullable=false, length=1)	
	private boolean porcentajeOferta;
	
	@Column(name="UrlImagen", nullable=true, length=255)	
	private String urlImagen;
	
	@OneToMany(mappedBy="aplica_oferta", targetEntity=basededatos.Producto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_contiene = new java.util.HashSet();
	
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
	
	public void setNombreOferta(String value) {
		this.nombreOferta = value;
	}
	
	public String getNombreOferta() {
		return nombreOferta;
	}
	
	public void setPorcentajeOferta(boolean value) {
		this.porcentajeOferta = value;
	}
	
	public boolean getPorcentajeOferta() {
		return porcentajeOferta;
	}
	
	public void setUrlImagen(String value) {
		this.urlImagen = value;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}
	
	private void setORM_Contiene(java.util.Set value) {
		this.ORM_contiene = value;
	}
	
	private java.util.Set getORM_Contiene() {
		return ORM_contiene;
	}
	
	@Transient	
	public final basededatos.ProductoSetCollection contiene = new basededatos.ProductoSetCollection(this, _ormAdapter, ORMConstants.KEY_OFERTA_CONTIENE, ORMConstants.KEY_PRODUCTO_APLICA_OFERTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
