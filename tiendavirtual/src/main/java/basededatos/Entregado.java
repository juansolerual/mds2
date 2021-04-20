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
@Table(name="Entregado")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="PedidoID", referencedColumnName="ID")
public class Entregado extends basededatos.Pedido implements Serializable {
	public Entregado() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ENTREGADO_GESTIONADO_POR) {
			this.gestionado_por = (basededatos.Transportista) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@ManyToOne(targetEntity=basededatos.Transportista.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TransportistaUsuarioID", referencedColumnName="UsuarioID", nullable=false) }, foreignKey=@ForeignKey(name="FKEntregado116749"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Transportista gestionado_por;
	
	public void setGestionado_por(basededatos.Transportista value) {
		if (gestionado_por != null) {
			gestionado_por.marca_como_entregado.remove(this);
		}
		if (value != null) {
			value.marca_como_entregado.add(this);
		}
	}
	
	public basededatos.Transportista getGestionado_por() {
		return gestionado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Gestionado_por(basededatos.Transportista value) {
		this.gestionado_por = value;
	}
	
	private basededatos.Transportista getORM_Gestionado_por() {
		return gestionado_por;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
