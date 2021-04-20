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
@Table(name="Lineas_de_Pedido")
public class Lineas_de_Pedido implements Serializable {
	public Lineas_de_Pedido() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LINEAS_DE_PEDIDO_DE_UN) {
			this.de_un = (basededatos.Producto) owner;
		}
		
		else if (key == ORMConstants.KEY_LINEAS_DE_PEDIDO_PERTENECEN_A) {
			this.pertenecen_a = (basededatos.Pedido) owner;
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
	@GeneratedValue(generator="BASEDEDATOS_LINEAS_DE_PEDIDO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_LINEAS_DE_PEDIDO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToOne(optional=false, targetEntity=basededatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProductoID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKLineas_de_617012"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Producto de_un;
	
	@ManyToOne(targetEntity=basededatos.Pedido.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PedidoID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKLineas_de_374331"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Pedido pertenecen_a;
	
	@Column(name="Cantidad", nullable=false, length=10)	
	private int cantidad;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCantidad(int value) {
		this.cantidad = value;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setDe_un(basededatos.Producto value) {
		if (this.de_un != value) {
			basededatos.Producto lde_un = this.de_un;
			this.de_un = value;
			if (value != null) {
				de_un.setAsignado_a(this);
			}
			if (lde_un != null && lde_un.getAsignado_a() == this) {
				lde_un.setAsignado_a(null);
			}
		}
	}
	
	public basededatos.Producto getDe_un() {
		return de_un;
	}
	
	public void setPertenecen_a(basededatos.Pedido value) {
		if (pertenecen_a != null) {
			pertenecen_a.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public basededatos.Pedido getPertenecen_a() {
		return pertenecen_a;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenecen_a(basededatos.Pedido value) {
		this.pertenecen_a = value;
	}
	
	private basededatos.Pedido getORM_Pertenecen_a() {
		return pertenecen_a;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
