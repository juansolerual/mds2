package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Categoria;

public class BD_Categoria {
	public BDPrincipal _bDPrincipal;
	public Vector<Categoria> _contiene_categorias = new Vector<Categoria>();

	public List<Categoria> cargarCategorias() throws PersistentException {
		List<Categoria> categorias = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {	
			categorias = CategoriaDAO.queryCategoria(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return categorias;
	}

	public Categoria cargarCategoria(int aId) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCategoria(int aId) throws PersistentException {
		boolean resultado = false;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria cat = CategoriaDAO.getCategoriaByORMID(aId);
			resultado = CategoriaDAO.delete(cat);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
	}

	public int guardarCategoria(Categoria aCategoria) throws PersistentException {
		int id_categoria = -1;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {

			
			Categoria cat = CategoriaDAO.createCategoria();
			cat.setDescripcion(aCategoria.getDescripcion());
			cat.setNombreCategoria(aCategoria.getNombreCategoria());
			cat.setImagen(aCategoria.getImagen());
			
			CategoriaDAO.save(cat);
			id_categoria = cat.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return id_categoria;
	}
}