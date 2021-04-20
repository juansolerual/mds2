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

public class Lineas_de_PedidoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression de_unId;
	public final AssociationExpression de_un;
	public final IntegerExpression pertenecen_aId;
	public final AssociationExpression pertenecen_a;
	public final IntegerExpression cantidad;
	
	public Lineas_de_PedidoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		de_unId = new IntegerExpression("de_un.ID", this);
		de_un = new AssociationExpression("de_un", this);
		pertenecen_aId = new IntegerExpression("pertenecen_a.ID", this);
		pertenecen_a = new AssociationExpression("pertenecen_a", this);
		cantidad = new IntegerExpression("cantidad", this);
	}
	
	public Lineas_de_PedidoCriteria(PersistentSession session) {
		this(session.createCriteria(Lineas_de_Pedido.class));
	}
	
	public Lineas_de_PedidoCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createDe_unCriteria() {
		return new ProductoCriteria(createCriteria("de_un"));
	}
	
	public PedidoCriteria createPertenecen_aCriteria() {
		return new PedidoCriteria(createCriteria("pertenecen_a"));
	}
	
	public Lineas_de_Pedido uniqueLineas_de_Pedido() {
		return (Lineas_de_Pedido) super.uniqueResult();
	}
	
	public Lineas_de_Pedido[] listLineas_de_Pedido() {
		java.util.List list = super.list();
		return (Lineas_de_Pedido[]) list.toArray(new Lineas_de_Pedido[list.size()]);
	}
}

