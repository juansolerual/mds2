package basededatos;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Producto;

public class BD_Producto {
	public BDPrincipal _bDPrincipal;
	public Vector<Producto> _contiene_productos = new Vector<Producto>();

	public List<Producto> cargarProductos() throws PersistentException {
		List<Producto> productos = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			productos = ProductoDAO.queryProducto(null, null);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return productos;
	}

	public Producto cargarProducto(int aIdProducto) throws PersistentException {
		Producto producto = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			producto = ProductoDAO.getProductoByORMID(aIdProducto);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return producto;
	}

	public boolean eliminarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public Producto[] verProductosCategoria(int aIdCategoria) {
		throw new UnsupportedOperationException();
	}

	public int guardarProducto(Producto aProducto) throws PersistentException {
		int id_producto = -1;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			
			
			
			
			Producto prod = ProductoDAO.createProducto();
			prod.setCaracteristicas(aProducto.getCaracteristicas());
			prod.setDescripcion(aProducto.getDescripcion());
			prod.setPrecio(aProducto.getPrecio());
			prod.setNombreProducto(aProducto.getNombreProducto());
			prod.setPertenece_a(aProducto.getPertenece_a());
			prod.setAplica_oferta(aProducto.getAplica_oferta());
			ProductoDAO.save(prod);
			id_producto = prod.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return id_producto;
	}

	public List<Producto> cargarProductos(String string) throws PersistentException {
		List<Producto> productos = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			ProductoCriteria productoCriteria = new ProductoCriteria();
			productoCriteria.nombreProducto.like("%"+string+"%");
			Producto[] productos2 = ProductoDAO.listProductoByCriteria(productoCriteria);
			productos = Arrays.asList(productos2);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return productos;
	}

	public int editarProducto(Producto producto) throws PersistentException {
		// TODO Auto-generated method stub
		int resultado = -1;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		//ProductoDAO.delete(producto);
		try {
//			Producto prod = ProductoDAO.createProducto();
//			prod.setCaracteristicas(producto.getCaracteristicas());
//			prod.setDescripcion(producto.getDescripcion());
//			prod.setPrecio(producto.getPrecio());
//			prod.setNombreProducto(producto.getNombreProducto());
//			prod.setPertenece_a(producto.getPertenece_a());
//			prod.setAplica_oferta(producto.getAplica_oferta());
			ProductoDAO.save(producto);
			resultado = producto.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		
		return resultado;
	}
}