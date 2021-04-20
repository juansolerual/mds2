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
@Table(name="Transportista")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioID", referencedColumnName="ID")
public class Transportista extends basededatos.Usuario implements Serializable {
	public Transportista() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TRANSPORTISTA_MARCA_COMO_ENTREGADO) {
			return ORM_marca_como_entregado;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="gestionado_por", targetEntity=basededatos.Entregado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_marca_como_entregado = new java.util.HashSet();
	
	private void setORM_Marca_como_entregado(java.util.Set value) {
		this.ORM_marca_como_entregado = value;
	}
	
	private java.util.Set getORM_Marca_como_entregado() {
		return ORM_marca_como_entregado;
	}
	
	@Transient	
	public final basededatos.EntregadoSetCollection marca_como_entregado = new basededatos.EntregadoSetCollection(this, _ormAdapter, ORMConstants.KEY_TRANSPORTISTA_MARCA_COMO_ENTREGADO, ORMConstants.KEY_ENTREGADO_GESTIONADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
