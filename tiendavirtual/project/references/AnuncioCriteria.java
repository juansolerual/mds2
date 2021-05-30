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

public class AnuncioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression creadoPorId;
	public final AssociationExpression creadoPor;
	public final StringExpression textoAnuncio;
	public final StringExpression URLimagenAnuncio;
	public final StringExpression linkURL;
	
	public AnuncioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		creadoPorId = new IntegerExpression("creadoPor.", this);
		creadoPor = new AssociationExpression("creadoPor", this);
		textoAnuncio = new StringExpression("textoAnuncio", this);
		URLimagenAnuncio = new StringExpression("URLimagenAnuncio", this);
		linkURL = new StringExpression("linkURL", this);
	}
	
	public AnuncioCriteria(PersistentSession session) {
		this(session.createCriteria(Anuncio.class));
	}
	
	public AnuncioCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public Encargado_comprasCriteria createCreadoPorCriteria() {
		return new Encargado_comprasCriteria(createCriteria("creadoPor"));
	}
	
	public Anuncio uniqueAnuncio() {
		return (Anuncio) super.uniqueResult();
	}
	
	public Anuncio[] listAnuncio() {
		java.util.List list = super.list();
		return (Anuncio[]) list.toArray(new Anuncio[list.size()]);
	}
}

