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

public class ValoracionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression valorado_porId;
	public final AssociationExpression valorado_por;
	public final IntegerExpression producto_valoradoId;
	public final AssociationExpression producto_valorado;
	public final IntegerExpression valoracion;
	public final StringExpression comentario;
	
	public ValoracionDetachedCriteria() {
		super(basededatos.Valoracion.class, basededatos.ValoracionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		valorado_porId = new IntegerExpression("valorado_por.", this.getDetachedCriteria());
		valorado_por = new AssociationExpression("valorado_por", this.getDetachedCriteria());
		producto_valoradoId = new IntegerExpression("producto_valorado.ID", this.getDetachedCriteria());
		producto_valorado = new AssociationExpression("producto_valorado", this.getDetachedCriteria());
		valoracion = new IntegerExpression("valoracion", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
	}
	
	public ValoracionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.ValoracionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		valorado_porId = new IntegerExpression("valorado_por.", this.getDetachedCriteria());
		valorado_por = new AssociationExpression("valorado_por", this.getDetachedCriteria());
		producto_valoradoId = new IntegerExpression("producto_valorado.ID", this.getDetachedCriteria());
		producto_valorado = new AssociationExpression("producto_valorado", this.getDetachedCriteria());
		valoracion = new IntegerExpression("valoracion", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createValorado_porCriteria() {
		return new ClienteDetachedCriteria(createCriteria("valorado_por"));
	}
	
	public ProductoDetachedCriteria createProducto_valoradoCriteria() {
		return new ProductoDetachedCriteria(createCriteria("producto_valorado"));
	}
	
	public Valoracion uniqueValoracion(PersistentSession session) {
		return (Valoracion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Valoracion[] listValoracion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Valoracion[]) list.toArray(new Valoracion[list.size()]);
	}
}

