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
@Table(name="Encargado_compras")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioID", referencedColumnName="ID")
public class Encargado_compras extends basededatos.Usuario implements Serializable {
	public Encargado_compras() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ENCARGADO_COMPRAS_MARCA_COMO_ENVIADO) {
			return ORM_marca_como_enviado;
		}
		else if (key == ORMConstants.KEY_ENCARGADO_COMPRAS_CREA) {
			return ORM_crea;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="marcado_por", targetEntity=basededatos.Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_marca_como_enviado = new java.util.HashSet();
	
	@OneToMany(mappedBy="creadoPor", targetEntity=basededatos.Anuncio.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_crea = new java.util.HashSet();
	
	private void setORM_Marca_como_enviado(java.util.Set value) {
		this.ORM_marca_como_enviado = value;
	}
	
	private java.util.Set getORM_Marca_como_enviado() {
		return ORM_marca_como_enviado;
	}
	
	@Transient	
	public final basededatos.PedidoSetCollection marca_como_enviado = new basededatos.PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_ENCARGADO_COMPRAS_MARCA_COMO_ENVIADO, ORMConstants.KEY_PEDIDO_MARCADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Crea(java.util.Set value) {
		this.ORM_crea = value;
	}
	
	private java.util.Set getORM_Crea() {
		return ORM_crea;
	}
	
	@Transient	
	public final basededatos.AnuncioSetCollection crea = new basededatos.AnuncioSetCollection(this, _ormAdapter, ORMConstants.KEY_ENCARGADO_COMPRAS_CREA, ORMConstants.KEY_ANUNCIO_CREADOPOR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
