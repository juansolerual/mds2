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

public class ProductoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression aplica_ofertaId;
	public final AssociationExpression aplica_oferta;
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
	
	public ProductoDetachedCriteria() {
		super(basededatos.Producto.class, basededatos.ProductoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		aplica_ofertaId = new IntegerExpression("aplica_oferta.ID", this.getDetachedCriteria());
		aplica_oferta = new AssociationExpression("aplica_oferta", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		caracteristicas = new StringExpression("caracteristicas", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		nombreProducto = new StringExpression("nombreProducto", this.getDetachedCriteria());
		limiteFotos = new IntegerExpression("limiteFotos", this.getDetachedCriteria());
		tieneFoto = new CollectionExpression("ORM_tieneFoto", this.getDetachedCriteria());
		recibe_valoracion = new CollectionExpression("ORM_recibe_valoracion", this.getDetachedCriteria());
		asignado_aId = new IntegerExpression("asignado_a.ID", this.getDetachedCriteria());
		asignado_a = new AssociationExpression("asignado_a", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.ProductoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		aplica_ofertaId = new IntegerExpression("aplica_oferta.ID", this.getDetachedCriteria());
		aplica_oferta = new AssociationExpression("aplica_oferta", this.getDetachedCriteria());
		pertenece_aId = new IntegerExpression("pertenece_a.ID", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		caracteristicas = new StringExpression("caracteristicas", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		nombreProducto = new StringExpression("nombreProducto", this.getDetachedCriteria());
		limiteFotos = new IntegerExpression("limiteFotos", this.getDetachedCriteria());
		tieneFoto = new CollectionExpression("ORM_tieneFoto", this.getDetachedCriteria());
		recibe_valoracion = new CollectionExpression("ORM_recibe_valoracion", this.getDetachedCriteria());
		asignado_aId = new IntegerExpression("asignado_a.ID", this.getDetachedCriteria());
		asignado_a = new AssociationExpression("asignado_a", this.getDetachedCriteria());
	}
	
	public OfertaDetachedCriteria createAplica_ofertaCriteria() {
		return new OfertaDetachedCriteria(createCriteria("aplica_oferta"));
	}
	
	public CategoriaDetachedCriteria createPertenece_aCriteria() {
		return new CategoriaDetachedCriteria(createCriteria("pertenece_a"));
	}
	
	public FotoDetachedCriteria createTieneFotoCriteria() {
		return new FotoDetachedCriteria(createCriteria("ORM_tieneFoto"));
	}
	
	public ValoracionDetachedCriteria createRecibe_valoracionCriteria() {
		return new ValoracionDetachedCriteria(createCriteria("ORM_recibe_valoracion"));
	}
	
	public Lineas_de_PedidoDetachedCriteria createAsignado_aCriteria() {
		return new Lineas_de_PedidoDetachedCriteria(createCriteria("asignado_a"));
	}
	
	public Producto uniqueProducto(PersistentSession session) {
		return (Producto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Producto[] listProducto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Producto[]) list.toArray(new Producto[list.size()]);
	}
}

