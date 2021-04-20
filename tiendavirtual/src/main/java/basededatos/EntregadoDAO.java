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

public class EntregadoDAO {
	public static Entregado loadEntregadoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEntregadoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado getEntregadoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getEntregadoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEntregadoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado getEntregadoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getEntregadoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Entregado) session.load(basededatos.Entregado.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado getEntregadoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Entregado) session.get(basededatos.Entregado.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Entregado) session.load(basededatos.Entregado.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado getEntregadoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Entregado) session.get(basededatos.Entregado.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEntregado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryEntregado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEntregado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryEntregado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado[] listEntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listEntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado[] listEntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listEntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEntregado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Entregado as Entregado");
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
	
	public static List queryEntregado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Entregado as Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Entregado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado[] listEntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEntregado(session, condition, orderBy);
			return (Entregado[]) list.toArray(new Entregado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado[] listEntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEntregado(session, condition, orderBy, lockMode);
			return (Entregado[]) list.toArray(new Entregado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Entregado[] entregados = listEntregadoByQuery(session, condition, orderBy);
		if (entregados != null && entregados.length > 0)
			return entregados[0];
		else
			return null;
	}
	
	public static Entregado loadEntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Entregado[] entregados = listEntregadoByQuery(session, condition, orderBy, lockMode);
		if (entregados != null && entregados.length > 0)
			return entregados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateEntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateEntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Entregado as Entregado");
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
	
	public static java.util.Iterator iterateEntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Entregado as Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Entregado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado createEntregado() {
		return new basededatos.Entregado();
	}
	
	public static boolean save(basededatos.Entregado entregado) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().saveObject(entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Entregado entregado) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().deleteObject(entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Entregado entregado)throws PersistentException {
		try {
			if (entregado.getGestionado_por() != null) {
				entregado.getGestionado_por().marca_como_entregado.remove(entregado);
			}
			
			if (entregado.getMarcado_por() != null) {
				entregado.getMarcado_por().marca_como_enviado.remove(entregado);
			}
			
			basededatos.Lineas_de_Pedido[] lTienes = entregado.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenecen_a(null);
			}
			if (entregado.getRealizado_por() != null) {
				entregado.getRealizado_por().setRealiza_(null);
			}
			
			return delete(entregado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Entregado entregado, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (entregado.getGestionado_por() != null) {
				entregado.getGestionado_por().marca_como_entregado.remove(entregado);
			}
			
			if (entregado.getMarcado_por() != null) {
				entregado.getMarcado_por().marca_como_enviado.remove(entregado);
			}
			
			basededatos.Lineas_de_Pedido[] lTienes = entregado.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenecen_a(null);
			}
			if (entregado.getRealizado_por() != null) {
				entregado.getRealizado_por().setRealiza_(null);
			}
			
			try {
				session.delete(entregado);
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
	
	public static boolean refresh(basededatos.Entregado entregado) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().refresh(entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Entregado entregado) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().evict(entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Entregado loadEntregadoByCriteria(EntregadoCriteria entregadoCriteria) {
		Entregado[] entregados = listEntregadoByCriteria(entregadoCriteria);
		if(entregados == null || entregados.length == 0) {
			return null;
		}
		return entregados[0];
	}
	
	public static Entregado[] listEntregadoByCriteria(EntregadoCriteria entregadoCriteria) {
		return entregadoCriteria.listEntregado();
	}
}
