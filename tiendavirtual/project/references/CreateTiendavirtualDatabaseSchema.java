/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTiendavirtualDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(basededatos.TiendavirtualPersistentManager.instance());
			basededatos.TiendavirtualPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
