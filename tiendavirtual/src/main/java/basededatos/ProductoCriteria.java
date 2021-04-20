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

public class ProductoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pertenece_a_Id;
	public final AssociationExpression pertenece_a_;
	public final IntegerExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final StringExpression caracteristicas;
	public final StringExpression descripcion;
	public final DoubleExpression precio;
	public final StringExpression nombreProducto;
	public final IntegerExpression limiteFotos;
	public final CollectionExpression tieneFoto;
	public final CollectionExpression recibe_valoracion;
	public final IntegerExpression asignado_aId;
	public final AssociationExpression asignado_a;
	
	public ProductoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		pertenece_a_Id = new IntegerExpression("pertenece_a_.ID", this);
		pertenece_a_ = new AssociationExpression("pertenece_a_", this);
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		caracteristicas = new StringExpression("caracteristicas", this);
		descripcion = new StringExpression("descripcion", this);
		precio = new DoubleExpression("precio", this);
		nombreProducto = new StringExpression("nombreProducto", this);
		limiteFotos = new IntegerExpression("limiteFotos", this);
		tieneFoto = new CollectionExpression("ORM_tieneFoto", this);
		recibe_valoracion = new CollectionExpression("ORM_recibe_valoracion", this);
		asignado_aId = new IntegerExpression("asignado_a.ID", this);
		asignado_a = new AssociationExpression("asignado_a", this);
	}
	
	public ProductoCriteria(PersistentSession session) {
		this(session.createCriteria(Producto.class));
	}
	
	public ProductoCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public OfertaCriteria createPertenece_a_Criteria() {
		return new OfertaCriteria(createCriteria("pertenece_a_"));
	}
	
	public CategoriaCriteria createPertenece_aCriteria() {
		return new CategoriaCriteria(createCriteria("pertenece_a"));
	}
	
	public FotoCriteria createTieneFotoCriteria() {
		return new FotoCriteria(createCriteria("ORM_tieneFoto"));
	}
	
	public ValoracionCriteria createRecibe_valoracionCriteria() {
		return new ValoracionCriteria(createCriteria("ORM_recibe_valoracion"));
	}
	
	public Lineas_de_PedidoCriteria createAsignado_aCriteria() {
		return new Lineas_de_PedidoCriteria(createCriteria("asignado_a"));
	}
	
	public Producto uniqueProducto() {
		return (Producto) super.uniqueResult();
	}
	
	public Producto[] listProducto() {
		java.util.List list = super.list();
		return (Producto[]) list.toArray(new Producto[list.size()]);
	}
}

