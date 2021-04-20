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
@Table(name="Anuncio")
public class Anuncio implements Serializable {
	public Anuncio() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ANUNCIO_CREADOPOR) {
			this.creadoPor = (basededatos.Encargado_compras) owner;
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
	@GeneratedValue(generator="BASEDEDATOS_ANUNCIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_ANUNCIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basededatos.Encargado_compras.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="Encargado_comprasUsuarioID", referencedColumnName="UsuarioID", nullable=false) }, foreignKey=@ForeignKey(name="FKAnuncio235124"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Encargado_compras creadoPor;
	
	@Column(name="TextoAnuncio", nullable=true, length=255)	
	private String textoAnuncio;
	
	@Column(name="URLimagenAnuncio", nullable=true, length=255)	
	private String URLimagenAnuncio;
	
	@Column(name="LinkURL", nullable=true, length=255)	
	private String linkURL;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTextoAnuncio(String value) {
		this.textoAnuncio = value;
	}
	
	public String getTextoAnuncio() {
		return textoAnuncio;
	}
	
	public void setURLimagenAnuncio(String value) {
		this.URLimagenAnuncio = value;
	}
	
	public String getURLimagenAnuncio() {
		return URLimagenAnuncio;
	}
	
	public void setLinkURL(String value) {
		this.linkURL = value;
	}
	
	public String getLinkURL() {
		return linkURL;
	}
	
	public void setCreadoPor(basededatos.Encargado_compras value) {
		if (creadoPor != null) {
			creadoPor.crea.remove(this);
		}
		if (value != null) {
			value.crea.add(this);
		}
	}
	
	public basededatos.Encargado_compras getCreadoPor() {
		return creadoPor;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_CreadoPor(basededatos.Encargado_compras value) {
		this.creadoPor = value;
	}
	
	private basededatos.Encargado_compras getORM_CreadoPor() {
		return creadoPor;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
