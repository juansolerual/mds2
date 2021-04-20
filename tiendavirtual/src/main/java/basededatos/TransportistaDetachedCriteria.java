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

public class TransportistaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression dni;
	public final StringExpression direccion;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression foto_perfil;
	public final StringExpression password;
	public final CollectionExpression gestiona;
	public final CollectionExpression marca_como_entregado;
	
	public TransportistaDetachedCriteria() {
		super(basededatos.Transportista.class, basededatos.TransportistaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		marca_como_entregado = new CollectionExpression("ORM_marca_como_entregado", this.getDetachedCriteria());
	}
	
	public TransportistaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.TransportistaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		dni = new StringExpression("dni", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		foto_perfil = new StringExpression("foto_perfil", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gestiona = new CollectionExpression("ORM_gestiona", this.getDetachedCriteria());
		marca_como_entregado = new CollectionExpression("ORM_marca_como_entregado", this.getDetachedCriteria());
	}
	
	public EntregadoDetachedCriteria createMarca_como_entregadoCriteria() {
		return new EntregadoDetachedCriteria(createCriteria("ORM_marca_como_entregado"));
	}
	
	public MensajeDetachedCriteria createGestionaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_gestiona"));
	}
	
	public Transportista uniqueTransportista(PersistentSession session) {
		return (Transportista) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Transportista[] listTransportista(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Transportista[]) list.toArray(new Transportista[list.size()]);
	}
}

