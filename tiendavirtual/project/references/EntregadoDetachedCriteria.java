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

public class EntregadoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression realizado_porId;
	public final AssociationExpression realizado_por;
	public final IntegerExpression marcado_porId;
	public final AssociationExpression marcado_por;
	public final DateExpression fechaPedido;
	public final TimeExpression horaPedido;
	public final BooleanExpression pagado;
	public final CollectionExpression tiene;
	public final IntegerExpression gestionado_porId;
	public final AssociationExpression gestionado_por;
	
	public EntregadoDetachedCriteria() {
		super(basededatos.Entregado.class, basededatos.EntregadoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		realizado_porId = new IntegerExpression("realizado_por.", this.getDetachedCriteria());
		realizado_por = new AssociationExpression("realizado_por", this.getDetachedCriteria());
		marcado_porId = new IntegerExpression("marcado_por.", this.getDetachedCriteria());
		marcado_por = new AssociationExpression("marcado_por", this.getDetachedCriteria());
		fechaPedido = new DateExpression("fechaPedido", this.getDetachedCriteria());
		horaPedido = new TimeExpression("horaPedido", this.getDetachedCriteria());
		pagado = new BooleanExpression("pagado", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		gestionado_porId = new IntegerExpression("gestionado_por.", this.getDetachedCriteria());
		gestionado_por = new AssociationExpression("gestionado_por", this.getDetachedCriteria());
	}
	
	public EntregadoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.EntregadoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		realizado_porId = new IntegerExpression("realizado_por.", this.getDetachedCriteria());
		realizado_por = new AssociationExpression("realizado_por", this.getDetachedCriteria());
		marcado_porId = new IntegerExpression("marcado_por.", this.getDetachedCriteria());
		marcado_por = new AssociationExpression("marcado_por", this.getDetachedCriteria());
		fechaPedido = new DateExpression("fechaPedido", this.getDetachedCriteria());
		horaPedido = new TimeExpression("horaPedido", this.getDetachedCriteria());
		pagado = new BooleanExpression("pagado", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		gestionado_porId = new IntegerExpression("gestionado_por.", this.getDetachedCriteria());
		gestionado_por = new AssociationExpression("gestionado_por", this.getDetachedCriteria());
	}
	
	public TransportistaDetachedCriteria createGestionado_porCriteria() {
		return new TransportistaDetachedCriteria(createCriteria("gestionado_por"));
	}
	
	public ClienteDetachedCriteria createRealizado_porCriteria() {
		return new ClienteDetachedCriteria(createCriteria("realizado_por"));
	}
	
	public Encargado_comprasDetachedCriteria createMarcado_porCriteria() {
		return new Encargado_comprasDetachedCriteria(createCriteria("marcado_por"));
	}
	
	public Lineas_de_PedidoDetachedCriteria createTieneCriteria() {
		return new Lineas_de_PedidoDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public Entregado uniqueEntregado(PersistentSession session) {
		return (Entregado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Entregado[] listEntregado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Entregado[]) list.toArray(new Entregado[list.size()]);
	}
}

