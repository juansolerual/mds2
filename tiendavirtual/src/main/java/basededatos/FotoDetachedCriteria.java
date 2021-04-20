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

public class FotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final StringExpression URLFoto;
	public final BooleanExpression isPrincipal;
	
	public FotoDetachedCriteria() {
		super(basededatos.Foto.class, basededatos.FotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		URLFoto = new StringExpression("URLFoto", this.getDetachedCriteria());
		isPrincipal = new BooleanExpression("isPrincipal", this.getDetachedCriteria());
	}
	
	public FotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.FotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		URLFoto = new StringExpression("URLFoto", this.getDetachedCriteria());
		isPrincipal = new BooleanExpression("isPrincipal", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createPertenece_aCriteria() {
		return new ProductoDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public Foto uniqueFoto(PersistentSession session) {
		return (Foto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Foto[] listFoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Foto[]) list.toArray(new Foto[list.size()]);
	}
}

