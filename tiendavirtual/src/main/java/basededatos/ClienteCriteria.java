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

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression dni;
	public final StringExpression direccion;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression foto_perfil;
	public final StringExpression password;
	public final CollectionExpression gestiona;
	public final IntegerExpression realiza_Id;
	public final AssociationExpression realiza_;
	public final CollectionExpression realiza;
	
	public ClienteCriteria(Criteria criteria) {
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
		realiza_Id = new IntegerExpression("realiza_.ID", this);
		realiza_ = new AssociationExpression("realiza_", this);
		realiza = new CollectionExpression("ORM_realiza", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public PedidoCriteria createRealiza_Criteria() {
		return new PedidoCriteria(createCriteria("realiza_"));
	}
	
	public ValoracionCriteria createRealizaCriteria() {
		return new ValoracionCriteria(createCriteria("ORM_realiza"));
	}
	
	public MensajeCriteria createGestionaCriteria() {
		return new MensajeCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

