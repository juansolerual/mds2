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
		else if (key == ORMConstants.KEY_CLIENTE_REALIZA_PEDIDO) {
			return ORM_realiza_pedido;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="FormaDePago", nullable=true, length=255)	
	private String formaDePago;
	
	@Column(name="DatosPago", nullable=true, length=255)	
	private String datosPago;
	
	@OneToMany(mappedBy="valorado_por", targetEntity=basededatos.Valoracion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_realiza = new java.util.HashSet();
	
	@OneToMany(mappedBy="realizado_por", targetEntity=basededatos.Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_realiza_pedido = new java.util.HashSet();
	
	public void setFormaDePago(String value) {
		this.formaDePago = value;
	}
	
	public String getFormaDePago() {
		return formaDePago;
	}
	
	public void setDatosPago(String value) {
		this.datosPago = value;
	}
	
	public String getDatosPago() {
		return datosPago;
	}
	
	private void setORM_Realiza(java.util.Set value) {
		this.ORM_realiza = value;
	}
	
	private java.util.Set getORM_Realiza() {
		return ORM_realiza;
	}
	
	@Transient	
	public final basededatos.ValoracionSetCollection realiza = new basededatos.ValoracionSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENTE_REALIZA, ORMConstants.KEY_VALORACION_VALORADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Realiza_pedido(java.util.Set value) {
		this.ORM_realiza_pedido = value;
	}
	
	private java.util.Set getORM_Realiza_pedido() {
		return ORM_realiza_pedido;
	}
	
	@Transient	
	public final basededatos.PedidoSetCollection realiza_pedido = new basededatos.PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENTE_REALIZA_PEDIDO, ORMConstants.KEY_PEDIDO_REALIZADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
