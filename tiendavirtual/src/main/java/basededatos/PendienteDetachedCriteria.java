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

public class PendienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression marcado_porId;
	public final AssociationExpression marcado_por;
	public final DateExpression fechaPedido;
	public final TimeExpression horaPedido;
	public final BooleanExpression pagado;
	public final CollectionExpression tiene;
	public final IntegerExpression realizado_porId;
	public final AssociationExpression realizado_por;
	
	public PendienteDetachedCriteria() {
		super(basededatos.Pendiente.class, basededatos.PendienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		marcado_porId = new IntegerExpression("marcado_por.", this.getDetachedCriteria());
		marcado_por = new AssociationExpression("marcado_por", this.getDetachedCriteria());
		fechaPedido = new DateExpression("fechaPedido", this.getDetachedCriteria());
		horaPedido = new TimeExpression("horaPedido", this.getDetachedCriteria());
		pagado = new BooleanExpression("pagado", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		realizado_porId = new IntegerExpression("realizado_por.ID", this.getDetachedCriteria());
		realizado_por = new AssociationExpression("realizado_por", this.getDetachedCriteria());
	}
	
	public PendienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.PendienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		marcado_porId = new IntegerExpression("marcado_por.", this.getDetachedCriteria());
		marcado_por = new AssociationExpression("marcado_por", this.getDetachedCriteria());
		fechaPedido = new DateExpression("fechaPedido", this.getDetachedCriteria());
		horaPedido = new TimeExpression("horaPedido", this.getDetachedCriteria());
		pagado = new BooleanExpression("pagado", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		realizado_porId = new IntegerExpression("realizado_por.ID", this.getDetachedCriteria());
		realizado_por = new AssociationExpression("realizado_por", this.getDetachedCriteria());
	}
	
	public Encargado_comprasDetachedCriteria createMarcado_porCriteria() {
		return new Encargado_comprasDetachedCriteria(createCriteria("marcado_por"));
	}
	
	public Lineas_de_PedidoDetachedCriteria createTieneCriteria() {
		return new Lineas_de_PedidoDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public ClienteDetachedCriteria createRealizado_porCriteria() {
		return new ClienteDetachedCriteria(createCriteria("realizado_por"));
	}
	
	public Pendiente uniquePendiente(PersistentSession session) {
		return (Pendiente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pendiente[] listPendiente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pendiente[]) list.toArray(new Pendiente[list.size()]);
	}
}

