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

public class CategoriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombreCategoria;
	public final StringExpression imagen;
	public final StringExpression descripcion;
	public final CollectionExpression contiene;
	
	public CategoriaDetachedCriteria() {
		super(basededatos.Categoria.class, basededatos.CategoriaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombreCategoria = new StringExpression("nombreCategoria", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public CategoriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.CategoriaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombreCategoria = new StringExpression("nombreCategoria", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createContieneCriteria() {
		return new ProductoDetachedCriteria(createCriteria("ORM_contiene"));
	}
	
	public Categoria uniqueCategoria(PersistentSession session) {
		return (Categoria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Categoria[] listCategoria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Categoria[]) list.toArray(new Categoria[list.size()]);
	}
}

