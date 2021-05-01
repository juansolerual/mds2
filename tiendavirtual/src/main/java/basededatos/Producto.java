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
@Table(name="Producto")
public class Producto implements Serializable {
	public Producto() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PRODUCTO_TIENEFOTO) {
			return ORM_tieneFoto;
		}
		else if (key == ORMConstants.KEY_PRODUCTO_RECIBE_VALORACION) {
			return ORM_recibe_valoracion;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PRODUCTO_APLICA_OFERTA) {
			this.aplica_oferta = (basededatos.Oferta) owner;
		}
		
		else if (key == ORMConstants.KEY_PRODUCTO_PERTENECE_A) {
			this.pertenece_a = (basededatos.Categoria) owner;
		}
		
		else if (key == ORMConstants.KEY_PRODUCTO_ASIGNADO_A) {
			this.asignado_a = (basededatos.Lineas_de_Pedido) owner;
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
	@GeneratedValue(generator="BASEDEDATOS_PRODUCTO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_PRODUCTO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basededatos.Oferta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="OfertaID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKProducto444947"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Oferta aplica_oferta;
	
	@ManyToOne(targetEntity=basededatos.Categoria.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CategoriaID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKProducto904736"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Categoria pertenece_a;
	
	@Column(name="Caracteristicas", nullable=true, length=255)	
	private String caracteristicas;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Precio", nullable=false)	
	private double precio;
	
	@Column(name="NombreProducto", nullable=true, length=255)	
	private String nombreProducto;
	
	@Column(name="LimiteFotos", nullable=false, length=10)	
	private int limiteFotos;
	
	@OneToMany(mappedBy="pertenece_a", targetEntity=basededatos.Foto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_tieneFoto = new java.util.HashSet();
	
	@OneToMany(mappedBy="producto_valorado", targetEntity=basededatos.Valoracion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_recibe_valoracion = new java.util.HashSet();
	
	@OneToOne(mappedBy="de_un", targetEntity=basededatos.Lineas_de_Pedido.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Lineas_de_Pedido asignado_a;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCaracteristicas(String value) {
		this.caracteristicas = value;
	}
	
	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setPrecio(double value) {
		this.precio = value;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setNombreProducto(String value) {
		this.nombreProducto = value;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setLimiteFotos(int value) {
		this.limiteFotos = value;
	}
	
	public int getLimiteFotos() {
		return limiteFotos;
	}
	
	public void setAplica_oferta(basededatos.Oferta value) {
		if (aplica_oferta != null) {
			aplica_oferta.contiene.remove(this);
		}
		if (value != null) {
			value.contiene.add(this);
		}
	}
	
	public basededatos.Oferta getAplica_oferta() {
		return aplica_oferta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Aplica_oferta(basededatos.Oferta value) {
		this.aplica_oferta = value;
	}
	
	private basededatos.Oferta getORM_Aplica_oferta() {
		return aplica_oferta;
	}
	
	private void setORM_TieneFoto(java.util.Set value) {
		this.ORM_tieneFoto = value;
	}
	
	private java.util.Set getORM_TieneFoto() {
		return ORM_tieneFoto;
	}
	
	@Transient	
	public final basededatos.FotoSetCollection tieneFoto = new basededatos.FotoSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_TIENEFOTO, ORMConstants.KEY_FOTO_PERTENECE_A, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Recibe_valoracion(java.util.Set value) {
		this.ORM_recibe_valoracion = value;
	}
	
	private java.util.Set getORM_Recibe_valoracion() {
		return ORM_recibe_valoracion;
	}
	
	@Transient	
	public final basededatos.ValoracionSetCollection recibe_valoracion = new basededatos.ValoracionSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_RECIBE_VALORACION, ORMConstants.KEY_VALORACION_PRODUCTO_VALORADO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPertenece_a(basededatos.Categoria value) {
		if (pertenece_a != null) {
			pertenece_a.contiene.remove(this);
		}
		if (value != null) {
			value.contiene.add(this);
		}
	}
	
	public basededatos.Categoria getPertenece_a() {
		return pertenece_a;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece_a(basededatos.Categoria value) {
		this.pertenece_a = value;
	}
	
	private basededatos.Categoria getORM_Pertenece_a() {
		return pertenece_a;
	}
	
	public void setAsignado_a(basededatos.Lineas_de_Pedido value) {
		if (this.asignado_a != value) {
			basededatos.Lineas_de_Pedido lasignado_a = this.asignado_a;
			this.asignado_a = value;
			if (value != null) {
				asignado_a.setDe_un(this);
			}
			if (lasignado_a != null && lasignado_a.getDe_un() == this) {
				lasignado_a.setDe_un(null);
			}
		}
	}
	
	public basededatos.Lineas_de_Pedido getAsignado_a() {
		return asignado_a;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
