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
@Table(name="Pedido")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido implements Serializable {
	public Pedido() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PEDIDO_TIENE) {
			return ORM_tiene;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PEDIDO_REALIZADO_POR) {
			this.realizado_por = (basededatos.Cliente) owner;
		}
		
		else if (key == ORMConstants.KEY_PEDIDO_MARCADO_POR) {
			this.marcado_por = (basededatos.Encargado_compras) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_PEDIDO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_PEDIDO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basededatos.Encargado_compras.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="Encargado_comprasUsuarioID", referencedColumnName="UsuarioID", nullable=false) }, foreignKey=@ForeignKey(name="FKPedido875184"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Encargado_compras marcado_por;
	
	@Column(name="FechaPedido", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaPedido;
	
	@Column(name="HoraPedido", nullable=true)	
	private java.sql.Time horaPedido;
	
	@Column(name="Pagado", nullable=false, length=1)	
	private boolean pagado;
	
	@OneToMany(mappedBy="pertenecen_a", targetEntity=basededatos.Lineas_de_Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tiene = new java.util.HashSet();
	
	@OneToOne(mappedBy="realiza_", targetEntity=basededatos.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Cliente realizado_por;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setFechaPedido(java.util.Date value) {
		this.fechaPedido = value;
	}
	
	public java.util.Date getFechaPedido() {
		return fechaPedido;
	}
	
	public void setHoraPedido(java.sql.Time value) {
		this.horaPedido = value;
	}
	
	public java.sql.Time getHoraPedido() {
		return horaPedido;
	}
	
	public void setPagado(boolean value) {
		this.pagado = value;
	}
	
	public boolean getPagado() {
		return pagado;
	}
	
	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}
	
	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}
	
	@Transient	
	public final basededatos.Lineas_de_PedidoSetCollection tiene = new basededatos.Lineas_de_PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_PEDIDO_TIENE, ORMConstants.KEY_LINEAS_DE_PEDIDO_PERTENECEN_A, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setRealizado_por(basededatos.Cliente value) {
		if (this.realizado_por != value) {
			basededatos.Cliente lrealizado_por = this.realizado_por;
			this.realizado_por = value;
			if (value != null) {
				realizado_por.setRealiza_(this);
			}
			if (lrealizado_por != null && lrealizado_por.getRealiza_() == this) {
				lrealizado_por.setRealiza_(null);
			}
		}
	}
	
	public basededatos.Cliente getRealizado_por() {
		return realizado_por;
	}
	
	public void setMarcado_por(basededatos.Encargado_compras value) {
		if (marcado_por != null) {
			marcado_por.marca_como_enviado.remove(this);
		}
		if (value != null) {
			value.marca_como_enviado.add(this);
		}
	}
	
	public basededatos.Encargado_compras getMarcado_por() {
		return marcado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Marcado_por(basededatos.Encargado_compras value) {
		this.marcado_por = value;
	}
	
	private basededatos.Encargado_compras getORM_Marcado_por() {
		return marcado_por;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
