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

public class ValoracionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression valorado_porId;
	public final AssociationExpression valorado_por;
	public final IntegerExpression producto_valoradoId;
	public final AssociationExpression producto_valorado;
	public final IntegerExpression valoracion;
	public final StringExpression comentario;
	
	public ValoracionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		valorado_porId = new IntegerExpression("valorado_por.", this);
		valorado_por = new AssociationExpression("valorado_por", this);
		producto_valoradoId = new IntegerExpression("producto_valorado.ID", this);
		producto_valorado = new AssociationExpression("producto_valorado", this);
		valoracion = new IntegerExpression("valoracion", this);
		comentario = new StringExpression("comentario", this);
	}
	
	public ValoracionCriteria(PersistentSession session) {
		this(session.createCriteria(Valoracion.class));
	}
	
	public ValoracionCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createValorado_porCriteria() {
		return new ClienteCriteria(createCriteria("valorado_por"));
	}
	
	public ProductoCriteria createProducto_valoradoCriteria() {
		return new ProductoCriteria(createCriteria("producto_valorado"));
	}
	
	public Valoracion uniqueValoracion() {
		return (Valoracion) super.uniqueResult();
	}
	
	public Valoracion[] listValoracion() {
		java.util.List list = super.list();
		return (Valoracion[]) list.toArray(new Valoracion[list.size()]);
	}
}

