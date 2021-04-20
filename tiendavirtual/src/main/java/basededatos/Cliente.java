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
@Table(name="Cliente")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioID", referencedColumnName="ID")
public class Cliente extends basededatos.Usuario implements Serializable {
	public Cliente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLIENTE_REALIZA) {
			return ORM_realiza;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToOne(targetEntity=basededatos.Pedido.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PedidoID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="FKCliente404964"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Pedido realiza_;
	
	@OneToMany(mappedBy="valorado_por", targetEntity=basededatos.Valoracion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_realiza = new java.util.HashSet();
	
	public void setRealiza_(basededatos.Pedido value) {
		if (this.realiza_ != value) {
			basededatos.Pedido lrealiza_ = this.realiza_;
			this.realiza_ = value;
			if (value != null) {
				realiza_.setRealizado_por(this);
			}
			if (lrealiza_ != null && lrealiza_.getRealizado_por() == this) {
				lrealiza_.setRealizado_por(null);
			}
		}
	}
	
	public basededatos.Pedido getRealiza_() {
		return realiza_;
	}
	
	private void setORM_Realiza(java.util.Set value) {
		this.ORM_realiza = value;
	}
	
	private java.util.Set getORM_Realiza() {
		return ORM_realiza;
	}
	
	@Transient	
	public final basededatos.ValoracionSetCollection realiza = new basededatos.ValoracionSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENTE_REALIZA, ORMConstants.KEY_VALORACION_VALORADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
