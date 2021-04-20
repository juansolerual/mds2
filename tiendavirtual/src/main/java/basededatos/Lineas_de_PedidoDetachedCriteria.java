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

public class Lineas_de_PedidoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression de_unId;
	public final AssociationExpression de_un;
	public final IntegerExpression pertenecen_aId;
	public final AssociationExpression pertenecen_a;
	public final IntegerExpression cantidad;
	
	public Lineas_de_PedidoDetachedCriteria() {
		super(basededatos.Lineas_de_Pedido.class, basededatos.Lineas_de_PedidoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		de_unId = new IntegerExpression("de_un.ID", this.getDetachedCriteria());
		de_un = new AssociationExpression("de_un", this.getDetachedCriteria());
		pertenecen_aId = new IntegerExpression("pertenecen_a.ID", this.getDetachedCriteria());
		pertenecen_a = new AssociationExpression("pertenecen_a", this.getDetachedCriteria());
		cantidad = new IntegerExpression("cantidad", this.getDetachedCriteria());
	}
	
	public Lineas_de_PedidoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.Lineas_de_PedidoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		de_unId = new IntegerExpression("de_un.ID", this.getDetachedCriteria());
		de_un = new AssociationExpression("de_un", this.getDetachedCriteria());
		pertenecen_aId = new IntegerExpression("pertenecen_a.ID", this.getDetachedCriteria());
		pertenecen_a = new AssociationExpression("pertenecen_a", this.getDetachedCriteria());
		cantidad = new IntegerExpression("cantidad", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createDe_unCriteria() {
		return new ProductoDetachedCriteria(createCriteria("de_un"));
	}
	
	public PedidoDetachedCriteria createPertenecen_aCriteria() {
		return new PedidoDetachedCriteria(createCriteria("pertenecen_a"));
	}
	
	public Lineas_de_Pedido uniqueLineas_de_Pedido(PersistentSession session) {
		return (Lineas_de_Pedido) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lineas_de_Pedido[] listLineas_de_Pedido(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lineas_de_Pedido[]) list.toArray(new Lineas_de_Pedido[list.size()]);
	}
}

