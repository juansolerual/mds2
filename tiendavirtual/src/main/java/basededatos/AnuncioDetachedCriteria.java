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

public class AnuncioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression creadoPorId;
	public final AssociationExpression creadoPor;
	public final StringExpression textoAnuncio;
	public final StringExpression URLimagenAnuncio;
	public final StringExpression linkURL;
	
	public AnuncioDetachedCriteria() {
		super(basededatos.Anuncio.class, basededatos.AnuncioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		creadoPorId = new IntegerExpression("creadoPor.", this.getDetachedCriteria());
		creadoPor = new AssociationExpression("creadoPor", this.getDetachedCriteria());
		textoAnuncio = new StringExpression("textoAnuncio", this.getDetachedCriteria());
		URLimagenAnuncio = new StringExpression("URLimagenAnuncio", this.getDetachedCriteria());
		linkURL = new StringExpression("linkURL", this.getDetachedCriteria());
	}
	
	public AnuncioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.AnuncioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		creadoPorId = new IntegerExpression("creadoPor.", this.getDetachedCriteria());
		creadoPor = new AssociationExpression("creadoPor", this.getDetachedCriteria());
		textoAnuncio = new StringExpression("textoAnuncio", this.getDetachedCriteria());
		URLimagenAnuncio = new StringExpression("URLimagenAnuncio", this.getDetachedCriteria());
		linkURL = new StringExpression("linkURL", this.getDetachedCriteria());
	}
	
	public Encargado_comprasDetachedCriteria createCreadoPorCriteria() {
		return new Encargado_comprasDetachedCriteria(createCriteria("creadoPor"));
	}
	
	public Anuncio uniqueAnuncio(PersistentSession session) {
		return (Anuncio) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Anuncio[] listAnuncio(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Anuncio[]) list.toArray(new Anuncio[list.size()]);
	}
}

