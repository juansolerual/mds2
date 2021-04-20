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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ValoracionDAO {
	public static Valoracion loadValoracionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadValoracionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion getValoracionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getValoracionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadValoracionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion getValoracionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getValoracionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Valoracion) session.load(basededatos.Valoracion.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion getValoracionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Valoracion) session.get(basededatos.Valoracion.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Valoracion) session.load(basededatos.Valoracion.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion getValoracionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Valoracion) session.get(basededatos.Valoracion.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValoracion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryValoracion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValoracion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryValoracion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion[] listValoracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listValoracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion[] listValoracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listValoracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValoracion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Valoracion as Valoracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValoracion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Valoracion as Valoracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Valoracion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion[] listValoracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryValoracion(session, condition, orderBy);
			return (Valoracion[]) list.toArray(new Valoracion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion[] listValoracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryValoracion(session, condition, orderBy, lockMode);
			return (Valoracion[]) list.toArray(new Valoracion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadValoracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadValoracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Valoracion[] valoracions = listValoracionByQuery(session, condition, orderBy);
		if (valoracions != null && valoracions.length > 0)
			return valoracions[0];
		else
			return null;
	}
	
	public static Valoracion loadValoracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Valoracion[] valoracions = listValoracionByQuery(session, condition, orderBy, lockMode);
		if (valoracions != null && valoracions.length > 0)
			return valoracions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateValoracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateValoracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValoracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateValoracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValoracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Valoracion as Valoracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValoracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Valoracion as Valoracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Valoracion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion createValoracion() {
		return new basededatos.Valoracion();
	}
	
	public static boolean save(basededatos.Valoracion valoracion) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().saveObject(valoracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Valoracion valoracion) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().deleteObject(valoracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Valoracion valoracion)throws PersistentException {
		try {
			if (valoracion.getValorado_por() != null) {
				valoracion.getValorado_por().realiza.remove(valoracion);
			}
			
			if (valoracion.getProducto_valorado() != null) {
				valoracion.getProducto_valorado().recibe_valoracion.remove(valoracion);
			}
			
			return delete(valoracion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Valoracion valoracion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (valoracion.getValorado_por() != null) {
				valoracion.getValorado_por().realiza.remove(valoracion);
			}
			
			if (valoracion.getProducto_valorado() != null) {
				valoracion.getProducto_valorado().recibe_valoracion.remove(valoracion);
			}
			
			try {
				session.delete(valoracion);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(basededatos.Valoracion valoracion) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().refresh(valoracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Valoracion valoracion) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().evict(valoracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Valoracion loadValoracionByCriteria(ValoracionCriteria valoracionCriteria) {
		Valoracion[] valoracions = listValoracionByCriteria(valoracionCriteria);
		if(valoracions == null || valoracions.length == 0) {
			return null;
		}
		return valoracions[0];
	}
	
	public static Valoracion[] listValoracionByCriteria(ValoracionCriteria valoracionCriteria) {
		return valoracionCriteria.listValoracion();
	}
}
