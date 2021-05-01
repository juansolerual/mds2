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

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression dni;
	public final StringExpression direccion;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression foto_perfil;
	public final StringExpression password;
	public final CollectionExpression gestiona;
	public final CollectionExpression realiza;
	public final CollectionExpression realiza_pedido;
	
	public ClienteDetachedCriteria() {
		super(basededatos.Cliente.class, basededatos.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		realiza = new CollectionExpression("ORM_realiza", this.getDetachedCriteria());
		realiza_pedido = new CollectionExpression("ORM_realiza_pedido", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		realiza = new CollectionExpression("ORM_realiza", this.getDetachedCriteria());
		realiza_pedido = new CollectionExpression("ORM_realiza_pedido", this.getDetachedCriteria());
	}
	
	public ValoracionDetachedCriteria createRealizaCriteria() {
		return new ValoracionDetachedCriteria(createCriteria("ORM_realiza"));
	}
	
	public PedidoDetachedCriteria createRealiza_pedidoCriteria() {
		return new PedidoDetachedCriteria(createCriteria("ORM_realiza_pedido"));
	}
	
	public MensajeDetachedCriteria createGestionaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

