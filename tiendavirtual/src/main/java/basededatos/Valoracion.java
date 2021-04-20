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
@Table(name="Valoracion")
public class Valoracion implements Serializable {
	public Valoracion() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_VALORACION_PRODUCTO_VALORADO) {
			this.producto_valorado = (basededatos.Producto) owner;
		}
		
		else if (key == ORMConstants.KEY_VALORACION_VALORADO_POR) {
			this.valorado_por = (basededatos.Cliente) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_VALORACION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_VALORACION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basededatos.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ClienteUsuarioID", referencedColumnName="UsuarioID", nullable=false) }, foreignKey=@ForeignKey(name="FKValoracion994623"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Cliente valorado_por;
	
	@ManyToOne(targetEntity=basededatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProductoID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKValoracion666140"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Producto producto_valorado;
	
	@Column(name="Valoracion", nullable=false, length=10)	
	private int valoracion;
	
	@Column(name="Comentario", nullable=true, length=255)	
	private String comentario;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setValoracion(int value) {
		this.valoracion = value;
	}
	
	public int getValoracion() {
		return valoracion;
	}
	
	public void setComentario(String value) {
		this.comentario = value;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setProducto_valorado(basededatos.Producto value) {
		if (producto_valorado != null) {
			producto_valorado.recibe_valoracion.remove(this);
		}
		if (value != null) {
			value.recibe_valoracion.add(this);
		}
	}
	
	public basededatos.Producto getProducto_valorado() {
		return producto_valorado;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Producto_valorado(basededatos.Producto value) {
		this.producto_valorado = value;
	}
	
	private basededatos.Producto getORM_Producto_valorado() {
		return producto_valorado;
	}
	
	public void setValorado_por(basededatos.Cliente value) {
		if (valorado_por != null) {
			valorado_por.realiza.remove(this);
		}
		if (value != null) {
			value.realiza.add(this);
		}
	}
	
	public basededatos.Cliente getValorado_por() {
		return valorado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Valorado_por(basededatos.Cliente value) {
		this.valorado_por = value;
	}
	
	private basededatos.Cliente getORM_Valorado_por() {
		return valorado_por;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
