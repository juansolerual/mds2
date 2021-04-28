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

public class OfertaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DoubleExpression precioOferta;
	public final DateExpression fechaCaducidadOferta;
	public final BooleanExpression activada;
	public final StringExpression nombreOferta;
	public final BooleanExpression porcentajeOferta;
	public final CollectionExpression contiene;
	
	public OfertaDetachedCriteria() {
		super(basededatos.Oferta.class, basededatos.OfertaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		precioOferta = new DoubleExpression("precioOferta", this.getDetachedCriteria());
		fechaCaducidadOferta = new DateExpression("fechaCaducidadOferta", this.getDetachedCriteria());
		activada = new BooleanExpression("activada", this.getDetachedCriteria());
		nombreOferta = new StringExpression("nombreOferta", this.getDetachedCriteria());
		porcentajeOferta = new BooleanExpression("porcentajeOferta", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public OfertaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.OfertaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		precioOferta = new DoubleExpression("precioOferta", this.getDetachedCriteria());
		fechaCaducidadOferta = new DateExpression("fechaCaducidadOferta", this.getDetachedCriteria());
		activada = new BooleanExpression("activada", this.getDetachedCriteria());
		nombreOferta = new StringExpression("nombreOferta", this.getDetachedCriteria());
		porcentajeOferta = new BooleanExpression("porcentajeOferta", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createContieneCriteria() {
		return new ProductoDetachedCriteria(createCriteria("ORM_contiene"));
	}
	
	public Oferta uniqueOferta(PersistentSession session) {
		return (Oferta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Oferta[] listOferta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Oferta[]) list.toArray(new Oferta[list.size()]);
	}
}

