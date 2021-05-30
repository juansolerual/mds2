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
import org.orm.cfg.JDBCConnectionSetting;
import org.hibernate.*;
import java.util.Properties;
import org.hibernate.cfg.*;
import org.hibernate.boot.MetadataSources;

public class TiendavirtualPersistentManager extends PersistentManager {
	private static final String PROJECT_NAME = "Tiendavirtual";
	private static PersistentManager _instance = null;
	private static SessionType _sessionType = SessionType.THREAD_BASE;
	private static int _timeToAlive = 60000;
	private static JDBCConnectionSetting _connectionSetting = null;
	private static Properties _extraProperties = null;
	private static String _configurationFile = null;
	
	private TiendavirtualPersistentManager() throws PersistentException {
		super(_connectionSetting, _sessionType, _timeToAlive, new String[] {}, _extraProperties, _configurationFile);
		setFlushMode(FlushMode.AUTO);
	}
	
	@Override
	protected void configureMetadataSources(MetadataSources aMetadataSources) {
		super.configureMetadataSources(aMetadataSources);
		aMetadataSources.addAnnotatedClass(basededatos.Producto.class);
		aMetadataSources.addAnnotatedClass(basededatos.Categoria.class);
		aMetadataSources.addAnnotatedClass(basededatos.Usuario.class);
		aMetadataSources.addAnnotatedClass(basededatos.Encargado_compras.class);
		aMetadataSources.addAnnotatedClass(basededatos.Pedido.class);
		aMetadataSources.addAnnotatedClass(basededatos.Oferta.class);
		aMetadataSources.addAnnotatedClass(basededatos.Cliente.class);
		aMetadataSources.addAnnotatedClass(basededatos.Administrador.class);
		aMetadataSources.addAnnotatedClass(basededatos.Valoracion.class);
		aMetadataSources.addAnnotatedClass(basededatos.Anuncio.class);
		aMetadataSources.addAnnotatedClass(basededatos.Lineas_de_Pedido.class);
		aMetadataSources.addAnnotatedClass(basededatos.Transportista.class);
		aMetadataSources.addAnnotatedClass(basededatos.Mensaje.class);
		aMetadataSources.addAnnotatedClass(basededatos.Foto.class);
		aMetadataSources.addAnnotatedClass(basededatos.Enviado.class);
		aMetadataSources.addAnnotatedClass(basededatos.Pendiente.class);
		aMetadataSources.addAnnotatedClass(basededatos.Entregado.class);
	}
	
	public String getProjectName() {
		return PROJECT_NAME;
	}
	
	public static synchronized final PersistentManager instance() throws PersistentException {
		if (_instance == null) {
			_instance = new TiendavirtualPersistentManager();
		}
		
		return _instance;
	}
	
	public void disposePersistentManager() throws PersistentException {
		_instance = null;
		super.disposePersistentManager();
	}
	
	public static void setSessionType(SessionType sessionType) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session type after create PersistentManager instance");
		}
		else {
			_sessionType = sessionType;
		}
		
	}
	
	public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
		}
		else {
			_timeToAlive = timeInMs;
		}
		
	}
	
	public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
		}
		else {
			_connectionSetting = aConnectionSetting;
		}
		
	}
	
	public static void setHibernateProperties(Properties aProperties) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
		}
		else {
			_extraProperties = aProperties;
		}
		
	}
	
	public static void setConfigurationFile(String aConfigurationFile) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set configuration file after create PersistentManager instance");
		}
		else {
			_configurationFile = aConfigurationFile;
		}
		
	}
	
	public static void saveJDBCConnectionSetting() {
		PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
	}
}
