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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MensajeCriteria extends AbstractORMCriteria {
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
	
	public MensajeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		originalId = new IntegerExpression("original.ID", this);
		original = new AssociationExpression("original", this);
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		IdUsuarioDestinatario = new IntegerExpression("IdUsuarioDestinatario", this);
		idUsuarioRemitente = new IntegerExpression("idUsuarioRemitente", this);
		fechaEnvio = new DateExpression("fechaEnvio", this);
		horaEnvio = new TimeExpression("horaEnvio", this);
		asunto = new StringExpression("asunto", this);
		respuesta = new CollectionExpression("ORM_respuesta", this);
	}
	
	public MensajeCriteria(PersistentSession session) {
		this(session.createCriteria(Mensaje.class));
	}
	
	public MensajeCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public MensajeCriteria createOriginalCriteria() {
		return new MensajeCriteria(createCriteria("original"));
	}
	
	public UsuarioCriteria createPertenece_aCriteria() {
		return new UsuarioCriteria(createCriteria("pertenece_a"));
	}
	
	public MensajeCriteria createRespuestaCriteria() {
		return new MensajeCriteria(createCriteria("ORM_respuesta"));
	}
	
	public Mensaje uniqueMensaje() {
		return (Mensaje) super.uniqueResult();
	}
	
	public Mensaje[] listMensaje() {
		java.util.List list = super.list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

