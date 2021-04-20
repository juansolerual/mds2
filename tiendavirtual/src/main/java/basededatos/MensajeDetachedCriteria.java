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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MensajeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression originalId;
	public final AssociationExpression original;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final IntegerExpression IdUsuarioDestinatario;
	public final IntegerExpression idUsuarioRemitente;
	public final DateExpression fechaEnvio;
	public final TimeExpression horaEnvio;
	public final StringExpression asunto;
	public final CollectionExpression respuesta;
	
	public MensajeDetachedCriteria() {
		super(basededatos.Mensaje.class, basededatos.MensajeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		originalId = new IntegerExpression("original.ID", this.getDetachedCriteria());
		original = new AssociationExpression("original", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		IdUsuarioDestinatario = new IntegerExpression("IdUsuarioDestinatario", this.getDetachedCriteria());
		idUsuarioRemitente = new IntegerExpression("idUsuarioRemitente", this.getDetachedCriteria());
		fechaEnvio = new DateExpression("fechaEnvio", this.getDetachedCriteria());
		horaEnvio = new TimeExpression("horaEnvio", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		respuesta = new CollectionExpression("ORM_respuesta", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.MensajeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		originalId = new IntegerExpression("original.ID", this.getDetachedCriteria());
		original = new AssociationExpression("original", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		IdUsuarioDestinatario = new IntegerExpression("IdUsuarioDestinatario", this.getDetachedCriteria());
		idUsuarioRemitente = new IntegerExpression("idUsuarioRemitente", this.getDetachedCriteria());
		fechaEnvio = new DateExpression("fechaEnvio", this.getDetachedCriteria());
		horaEnvio = new TimeExpression("horaEnvio", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		respuesta = new CollectionExpression("ORM_respuesta", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria createOriginalCriteria() {
		return new MensajeDetachedCriteria(createCriteria("original"));
	}
	
	public UsuarioDetachedCriteria createPertenece_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public MensajeDetachedCriteria createRespuestaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_respuesta"));
	}
	
	public Mensaje uniqueMensaje(PersistentSession session) {
		return (Mensaje) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Mensaje[] listMensaje(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

