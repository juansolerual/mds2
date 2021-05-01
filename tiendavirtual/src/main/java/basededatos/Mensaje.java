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
@Table(name="Mensaje")
public class Mensaje implements Serializable {
	public Mensaje() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_MENSAJE_RESPUESTA) {
			return ORM_respuesta;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_MENSAJE_PERTENECE_A) {
			this.pertenece_a = (basededatos.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_ORIGINAL) {
			this.original = (basededatos.Mensaje) owner;
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
	@GeneratedValue(generator="BASEDEDATOS_MENSAJE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_MENSAJE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basededatos.Mensaje.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="MensajeID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje450815"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Mensaje original;
	
	@ManyToOne(targetEntity=basededatos.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje983572"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Usuario pertenece_a;
	
	@Column(name="IdUsuarioDestinatario", nullable=true, length=10)	
	private int IdUsuarioDestinatario;
	
	@Column(name="IdUsuarioRemitente", nullable=true, length=10)	
	private int idUsuarioRemitente;
	
	@Column(name="FechaEnvio", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaEnvio;
	
	@Column(name="HoraEnvio", nullable=true)	
	private java.sql.Time horaEnvio;
	
	@Column(name="Asunto", nullable=true, length=255)	
	private String asunto;
	
	@OneToMany(mappedBy="original", targetEntity=basededatos.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ORM_respuesta = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setIdUsuarioDestinatario(int value) {
		this.IdUsuarioDestinatario = value;
	}
	
	public int getIdUsuarioDestinatario() {
		return IdUsuarioDestinatario;
	}
	
	public void setIdUsuarioRemitente(int value) {
		this.idUsuarioRemitente = value;
	}
	
	public int getIdUsuarioRemitente() {
		return idUsuarioRemitente;
	}
	
	public void setFechaEnvio(java.util.Date value) {
		this.fechaEnvio = value;
	}
	
	public java.util.Date getFechaEnvio() {
		return fechaEnvio;
	}
	
	public void setHoraEnvio(java.sql.Time value) {
		this.horaEnvio = value;
	}
	
	public java.sql.Time getHoraEnvio() {
		return horaEnvio;
	}
	
	public void setAsunto(String value) {
		this.asunto = value;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	private void setORM_Respuesta(java.util.Set value) {
		this.ORM_respuesta = value;
	}
	
	private java.util.Set getORM_Respuesta() {
		return ORM_respuesta;
	}
	
	@Transient	
	public final basededatos.MensajeSetCollection respuesta = new basededatos.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_MENSAJE_RESPUESTA, ORMConstants.KEY_MENSAJE_ORIGINAL, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPertenece_a(basededatos.Usuario value) {
		if (pertenece_a != null) {
			pertenece_a.gestiona.remove(this);
		}
		if (value != null) {
			value.gestiona.add(this);
		}
	}
	
	public basededatos.Usuario getPertenece_a() {
		return pertenece_a;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece_a(basededatos.Usuario value) {
		this.pertenece_a = value;
	}
	
	private basededatos.Usuario getORM_Pertenece_a() {
		return pertenece_a;
	}
	
	public void setOriginal(basededatos.Mensaje value) {
		if (original != null) {
			original.respuesta.remove(this);
		}
		if (value != null) {
			value.respuesta.add(this);
		}
	}
	
	public basededatos.Mensaje getOriginal() {
		return original;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Original(basededatos.Mensaje value) {
		this.original = value;
	}
	
	private basededatos.Mensaje getORM_Original() {
		return original;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
