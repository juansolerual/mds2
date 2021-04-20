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

public class Lineas_de_PedidoDAO {
	public static Lineas_de_Pedido loadLineas_de_PedidoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadLineas_de_PedidoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido getLineas_de_PedidoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getLineas_de_PedidoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadLineas_de_PedidoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido getLineas_de_PedidoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getLineas_de_PedidoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Lineas_de_Pedido) session.load(basededatos.Lineas_de_Pedido.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido getLineas_de_PedidoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Lineas_de_Pedido) session.get(basededatos.Lineas_de_Pedido.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Lineas_de_Pedido) session.load(basededatos.Lineas_de_Pedido.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido getLineas_de_PedidoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Lineas_de_Pedido) session.get(basededatos.Lineas_de_Pedido.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLineas_de_Pedido(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryLineas_de_Pedido(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLineas_de_Pedido(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryLineas_de_Pedido(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido[] listLineas_de_PedidoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listLineas_de_PedidoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido[] listLineas_de_PedidoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listLineas_de_PedidoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLineas_de_Pedido(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Lineas_de_Pedido as Lineas_de_Pedido");
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
	
	public static List queryLineas_de_Pedido(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Lineas_de_Pedido as Lineas_de_Pedido");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lineas_de_Pedido", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido[] listLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLineas_de_Pedido(session, condition, orderBy);
			return (Lineas_de_Pedido[]) list.toArray(new Lineas_de_Pedido[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido[] listLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLineas_de_Pedido(session, condition, orderBy, lockMode);
			return (Lineas_de_Pedido[]) list.toArray(new Lineas_de_Pedido[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadLineas_de_PedidoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadLineas_de_PedidoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Lineas_de_Pedido[] lineas_de_Pedidos = listLineas_de_PedidoByQuery(session, condition, orderBy);
		if (lineas_de_Pedidos != null && lineas_de_Pedidos.length > 0)
			return lineas_de_Pedidos[0];
		else
			return null;
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Lineas_de_Pedido[] lineas_de_Pedidos = listLineas_de_PedidoByQuery(session, condition, orderBy, lockMode);
		if (lineas_de_Pedidos != null && lineas_de_Pedidos.length > 0)
			return lineas_de_Pedidos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLineas_de_PedidoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateLineas_de_PedidoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLineas_de_PedidoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateLineas_de_PedidoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Lineas_de_Pedido as Lineas_de_Pedido");
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
	
	public static java.util.Iterator iterateLineas_de_PedidoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Lineas_de_Pedido as Lineas_de_Pedido");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lineas_de_Pedido", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido createLineas_de_Pedido() {
		return new basededatos.Lineas_de_Pedido();
	}
	
	public static boolean save(basededatos.Lineas_de_Pedido lineas_de_Pedido) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().saveObject(lineas_de_Pedido);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Lineas_de_Pedido lineas_de_Pedido) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().deleteObject(lineas_de_Pedido);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Lineas_de_Pedido lineas_de_Pedido)throws PersistentException {
		try {
			if (lineas_de_Pedido.getDe_un() != null) {
				lineas_de_Pedido.getDe_un().setAsignado_a(null);
			}
			
			if (lineas_de_Pedido.getPertenecen_a() != null) {
				lineas_de_Pedido.getPertenecen_a().tiene.remove(lineas_de_Pedido);
			}
			
			return delete(lineas_de_Pedido);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Lineas_de_Pedido lineas_de_Pedido, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (lineas_de_Pedido.getDe_un() != null) {
				lineas_de_Pedido.getDe_un().setAsignado_a(null);
			}
			
			if (lineas_de_Pedido.getPertenecen_a() != null) {
				lineas_de_Pedido.getPertenecen_a().tiene.remove(lineas_de_Pedido);
			}
			
			try {
				session.delete(lineas_de_Pedido);
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
	
	public static boolean refresh(basededatos.Lineas_de_Pedido lineas_de_Pedido) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().refresh(lineas_de_Pedido);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Lineas_de_Pedido lineas_de_Pedido) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().evict(lineas_de_Pedido);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lineas_de_Pedido loadLineas_de_PedidoByCriteria(Lineas_de_PedidoCriteria lineas_de_PedidoCriteria) {
		Lineas_de_Pedido[] lineas_de_Pedidos = listLineas_de_PedidoByCriteria(lineas_de_PedidoCriteria);
		if(lineas_de_Pedidos == null || lineas_de_Pedidos.length == 0) {
			return null;
		}
		return lineas_de_Pedidos[0];
	}
	
	public static Lineas_de_Pedido[] listLineas_de_PedidoByCriteria(Lineas_de_PedidoCriteria lineas_de_PedidoCriteria) {
		return lineas_de_PedidoCriteria.listLineas_de_Pedido();
	}
}
