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
	public final StringExpression nombreOferta;
	public final BooleanExpression porcentajeOferta;
	public final CollectionExpression contiene;
	
	public OfertaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		precioOferta = new DoubleExpression("precioOferta", this);
		fechaCaducidadOferta = new DateExpression("fechaCaducidadOferta", this);
		activada = new BooleanExpression("activada", this);
		nombreOferta = new StringExpression("nombreOferta", this);
		porcentajeOferta = new BooleanExpression("porcentajeOferta", this);
		contiene = new CollectionExpression("ORM_contiene", this);
	}
	
	public OfertaCriteria(PersistentSession session) {
		this(session.createCriteria(Oferta.class));
	}
	
	public OfertaCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createContieneCriteria() {
		return new ProductoCriteria(createCriteria("ORM_contiene"));
	}
	
	public Oferta uniqueOferta() {
		return (Oferta) super.uniqueResult();
	}
	
	public Oferta[] listOferta() {
		java.util.List list = super.list();
		return (Oferta[]) list.toArray(new Oferta[list.size()]);
	}
}

