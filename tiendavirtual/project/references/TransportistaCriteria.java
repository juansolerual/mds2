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

public class TransportistaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression dni;
	public final StringExpression direccion;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression foto_perfil;
	public final StringExpression password;
	public final CollectionExpression gestiona;
	public final CollectionExpression marca_como_entregado;
	
	public TransportistaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		dni = new StringExpression("dni", this);
		direccion = new StringExpression("direccion", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		foto_perfil = new StringExpression("foto_perfil", this);
		password = new StringExpression("password", this);
		gestiona = new CollectionExpression("ORM_gestiona", this);
		marca_como_entregado = new CollectionExpression("ORM_marca_como_entregado", this);
	}
	
	public TransportistaCriteria(PersistentSession session) {
		this(session.createCriteria(Transportista.class));
	}
	
	public TransportistaCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public EntregadoCriteria createMarca_como_entregadoCriteria() {
		return new EntregadoCriteria(createCriteria("ORM_marca_como_entregado"));
	}
	
	public MensajeCriteria createGestionaCriteria() {
		return new MensajeCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Transportista uniqueTransportista() {
		return (Transportista) super.uniqueResult();
	}
	
	public Transportista[] listTransportista() {
		java.util.List list = super.list();
		return (Transportista[]) list.toArray(new Transportista[list.size()]);
	}
}

