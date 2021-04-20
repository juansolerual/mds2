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
@Table(name="Categoria")
public class Categoria implements Serializable {
	public Categoria() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CATEGORIA_CONTIENE) {
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
	@GeneratedValue(generator="BASEDEDATOS_CATEGORIA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_CATEGORIA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="NombreCategoria", nullable=true, length=255)	
	private String nombreCategoria;
	
	@Column(name="Imagen", nullable=true, length=255)	
	private String imagen;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@OneToMany(mappedBy="pertenece_a", targetEntity=basededatos.Producto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
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
	
	public void setNombreCategoria(String value) {
		this.nombreCategoria = value;
	}
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	
	/**
	 * URL de la imagen
	 */
	public void setImagen(String value) {
		this.imagen = value;
	}
	
	/**
	 * URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private void setORM_Contiene(java.util.Set value) {
		this.ORM_contiene = value;
	}
	
	private java.util.Set getORM_Contiene() {
		return ORM_contiene;
	}
	
	@Transient	
	public final basededatos.ProductoSetCollection contiene = new basededatos.ProductoSetCollection(this, _ormAdapter, ORMConstants.KEY_CATEGORIA_CONTIENE, ORMConstants.KEY_PRODUCTO_PERTENECE_A, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
