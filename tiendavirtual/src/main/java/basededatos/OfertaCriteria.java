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

public class OfertaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DoubleExpression precioOferta;
	public final DateExpression fechaCaducidadOferta;
	public final BooleanExpression activada;
	public final IntegerExpression contieneId;
	public final AssociationExpression contiene;
	
	public OfertaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		precioOferta = new DoubleExpression("precioOferta", this);
		fechaCaducidadOferta = new DateExpression("fechaCaducidadOferta", this);
		activada = new BooleanExpression("activada", this);
		contieneId = new IntegerExpression("contiene.ID", this);
		contiene = new AssociationExpression("contiene", this);
	}
	
	public OfertaCriteria(PersistentSession session) {
		this(session.createCriteria(Oferta.class));
	}
	
	public OfertaCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createContieneCriteria() {
		return new ProductoCriteria(createCriteria("contiene"));
	}
	
	public Oferta uniqueOferta() {
		return (Oferta) super.uniqueResult();
	}
	
	public Oferta[] listOferta() {
		java.util.List list = super.list();
		return (Oferta[]) list.toArray(new Oferta[list.size()]);
	}
}

