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

public class Encargado_comprasDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression dni;
	public final StringExpression direccion;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression foto_perfil;
	public final StringExpression password;
	public final CollectionExpression gestiona;
	public final CollectionExpression marca_como_enviado;
	public final CollectionExpression crea;
	
	public Encargado_comprasDetachedCriteria() {
		super(basededatos.Encargado_compras.class, basededatos.Encargado_comprasCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		marca_como_enviado = new CollectionExpression("ORM_marca_como_enviado", this.getDetachedCriteria());
		crea = new CollectionExpression("ORM_crea", this.getDetachedCriteria());
	}
	
	public Encargado_comprasDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.Encargado_comprasCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		marca_como_enviado = new CollectionExpression("ORM_marca_como_enviado", this.getDetachedCriteria());
		crea = new CollectionExpression("ORM_crea", this.getDetachedCriteria());
	}
	
	public PedidoDetachedCriteria createMarca_como_enviadoCriteria() {
		return new PedidoDetachedCriteria(createCriteria("ORM_marca_como_enviado"));
	}
	
	public AnuncioDetachedCriteria createCreaCriteria() {
		return new AnuncioDetachedCriteria(createCriteria("ORM_crea"));
	}
	
	public MensajeDetachedCriteria createGestionaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Encargado_compras uniqueEncargado_compras(PersistentSession session) {
		return (Encargado_compras) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Encargado_compras[] listEncargado_compras(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
	}
}

