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

public class Encargado_comprasCriteria extends AbstractORMCriteria {
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
	
	public Encargado_comprasCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		dni = new StringExpression("dni", this);
		direccion = new StringExpression("direccion", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		foto_perfil = new StringExpression("foto_perfil", this);
		password = new StringExpression("password", this);
		gestiona = new CollectionExpression("ORM_gestiona", this);
		marca_como_enviado = new CollectionExpression("ORM_marca_como_enviado", this);
		crea = new CollectionExpression("ORM_crea", this);
	}
	
	public Encargado_comprasCriteria(PersistentSession session) {
		this(session.createCriteria(Encargado_compras.class));
	}
	
	public Encargado_comprasCriteria() throws PersistentException {
		this(TiendavirtualPersistentManager.instance().getSession());
	}
	
	public PedidoCriteria createMarca_como_enviadoCriteria() {
		return new PedidoCriteria(createCriteria("ORM_marca_como_enviado"));
	}
	
	public AnuncioCriteria createCreaCriteria() {
		return new AnuncioCriteria(createCriteria("ORM_crea"));
	}
	
	public MensajeCriteria createGestionaCriteria() {
		return new MensajeCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Encargado_compras uniqueEncargado_compras() {
		return (Encargado_compras) super.uniqueResult();
	}
	
	public Encargado_compras[] listEncargado_compras() {
		java.util.List list = super.list();
		return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
	}
}

