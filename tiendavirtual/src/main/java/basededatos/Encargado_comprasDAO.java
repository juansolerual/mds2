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

public class Encargado_comprasDAO {
	public static Encargado_compras loadEncargado_comprasByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEncargado_comprasByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getEncargado_comprasByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEncargado_comprasByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return getEncargado_comprasByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Encargado_compras) session.load(basededatos.Encargado_compras.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Encargado_compras) session.get(basededatos.Encargado_compras.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Encargado_compras) session.load(basededatos.Encargado_compras.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Encargado_compras) session.get(basededatos.Encargado_compras.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryEncargado_compras(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return queryEncargado_compras(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return listEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Encargado_compras as Encargado_compras");
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
	
	public static List queryEncargado_compras(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Encargado_compras as Encargado_compras");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Encargado_compras", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEncargado_compras(session, condition, orderBy);
			return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEncargado_compras(session, condition, orderBy, lockMode);
			return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return loadEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByQuery(session, condition, orderBy);
		if (encargado_comprases != null && encargado_comprases.length > 0)
			return encargado_comprases[0];
		else
			return null;
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		if (encargado_comprases != null && encargado_comprases.length > 0)
			return encargado_comprases[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TiendavirtualPersistentManager.instance().getSession();
			return iterateEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Encargado_compras as Encargado_compras");
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
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Encargado_compras as Encargado_compras");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Encargado_compras", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras createEncargado_compras() {
		return new basededatos.Encargado_compras();
	}
	
	public static boolean save(basededatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().saveObject(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().deleteObject(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Encargado_compras encargado_compras)throws PersistentException {
		try {
			basededatos.Pedido[] lMarca_como_enviados = encargado_compras.marca_como_enviado.toArray();
			for(int i = 0; i < lMarca_como_enviados.length; i++) {
				lMarca_como_enviados[i].setMarcado_por(null);
			}
			basededatos.Anuncio[] lCreas = encargado_compras.crea.toArray();
			for(int i = 0; i < lCreas.length; i++) {
				lCreas[i].setCreadoPor(null);
			}
			basededatos.Mensaje[] lGestionas = encargado_compras.gestiona.toArray();
			for(int i = 0; i < lGestionas.length; i++) {
				lGestionas[i].setPertenece_a(null);
			}
			return delete(encargado_compras);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Encargado_compras encargado_compras, org.orm.PersistentSession session)throws PersistentException {
		try {
			basededatos.Pedido[] lMarca_como_enviados = encargado_compras.marca_como_enviado.toArray();
			for(int i = 0; i < lMarca_como_enviados.length; i++) {
				lMarca_como_enviados[i].setMarcado_por(null);
			}
			basededatos.Anuncio[] lCreas = encargado_compras.crea.toArray();
			for(int i = 0; i < lCreas.length; i++) {
				lCreas[i].setCreadoPor(null);
			}
			basededatos.Mensaje[] lGestionas = encargado_compras.gestiona.toArray();
			for(int i = 0; i < lGestionas.length; i++) {
				lGestionas[i].setPertenece_a(null);
			}
			try {
				session.delete(encargado_compras);
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
	
	public static boolean refresh(basededatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().refresh(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			TiendavirtualPersistentManager.instance().getSession().evict(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByCriteria(Encargado_comprasCriteria encargado_comprasCriteria) {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByCriteria(encargado_comprasCriteria);
		if(encargado_comprases == null || encargado_comprases.length == 0) {
			return null;
		}
		return encargado_comprases[0];
	}
	
	public static Encargado_compras[] listEncargado_comprasByCriteria(Encargado_comprasCriteria encargado_comprasCriteria) {
		return encargado_comprasCriteria.listEncargado_compras();
	}
}
