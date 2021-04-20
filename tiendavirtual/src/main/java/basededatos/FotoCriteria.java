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

public class FotoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final StringExpression URLFoto;
	public final BooleanExpression isPrincipal;
	
	public FotoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		URLFoto = new StringExpression("URLFoto", this);
		isPrincipal = new BooleanExpression("isPrincipal", this);
	}
	
	public FotoCriteria(PersistentSession session) {
		this(session.createCriteria(Foto.class));
	}
	
	public FotoCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createPertenece_aCriteria() {
		return new ProductoCriteria(createCriteria("pertenece_a"));
	}
	
	public Foto uniqueFoto() {
		return (Foto) super.uniqueResult();
	}
	
	public Foto[] listFoto() {
		java.util.List list = super.list();
		return (Foto[]) list.toArray(new Foto[list.size()]);
	}
}

