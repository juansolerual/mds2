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

public class EnviadoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression marcado_porId;
	public final AssociationExpression marcado_por;
	public final DateExpression fechaPedido;
	public final TimeExpression horaPedido;
	public final BooleanExpression pagado;
	public final CollectionExpression tiene;
	public final IntegerExpression realizado_porId;
	public final AssociationExpression realizado_por;
	
	public EnviadoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		marcado_porId = new IntegerExpression("marcado_por.", this);
		marcado_por = new AssociationExpression("marcado_por", this);
		fechaPedido = new DateExpression("fechaPedido", this);
		horaPedido = new TimeExpression("horaPedido", this);
		pagado = new BooleanExpression("pagado", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		realizado_porId = new IntegerExpression("realizado_por.ID", this);
		realizado_por = new AssociationExpression("realizado_por", this);
	}
	
	public EnviadoCriteria(PersistentSession session) {
		this(session.createCriteria(Enviado.class));
	}
	
	public EnviadoCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public Encargado_comprasCriteria createMarcado_porCriteria() {
		return new Encargado_comprasCriteria(createCriteria("marcado_por"));
	}
	
	public Lineas_de_PedidoCriteria createTieneCriteria() {
		return new Lineas_de_PedidoCriteria(createCriteria("ORM_tiene"));
	}
	
	public ClienteCriteria createRealizado_porCriteria() {
		return new ClienteCriteria(createCriteria("realizado_por"));
	}
	
	public Enviado uniqueEnviado() {
		return (Enviado) super.uniqueResult();
	}
	
	public Enviado[] listEnviado() {
		java.util.List list = super.list();
		return (Enviado[]) list.toArray(new Enviado[list.size()]);
	}
}

