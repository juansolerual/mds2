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

public class CategoriaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombreCategoria;
	public final StringExpression imagen;
	public final StringExpression descripcion;
	public final CollectionExpression contiene;
	
	public CategoriaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombreCategoria = new StringExpression("nombreCategoria", this);
		imagen = new StringExpression("imagen", this);
		descripcion = new StringExpression("descripcion", this);
		contiene = new CollectionExpression("ORM_contiene", this);
	}
	
	public CategoriaCriteria(PersistentSession session) {
		this(session.createCriteria(Categoria.class));
	}
	
	public CategoriaCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createContieneCriteria() {
		return new ProductoCriteria(createCriteria("ORM_contiene"));
	}
	
	public Categoria uniqueCategoria() {
		return (Categoria) super.uniqueResult();
	}
	
	public Categoria[] listCategoria() {
		java.util.List list = super.list();
		return (Categoria[]) list.toArray(new Categoria[list.size()]);
	}
}

