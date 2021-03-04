package tiendavirtual.interfaz;

import java.util.Vector;

import tiendavirtual.interfaz.Producto_Carrito;

public class Lista_elementos_carrito {
	private event _eliminar_Producto_del_carrito;
	private event _modificar_cantidad_unidades;
	public Elementos_comunes_carrito _elementos_comunes_carrito;
	public Vector<Producto_Carrito> _list_Producto_Carrito = new Vector<Producto_Carrito>();

	public void Eliminar_Producto_del_carrito() {
		throw new UnsupportedOperationException();
	}

	public void Modificar_cantidad_unidades() {
		throw new UnsupportedOperationException();
	}
}