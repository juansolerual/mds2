package tiendavirtual.interfaz;

import java.util.List;

// import java.util.Vector;

import tiendavirtual.interfaz.Producto_usuario;
import vistas.VistaProductos_usuario;

public class Productos_Usuario extends VistaProductos_usuario{
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	//public Vector<Producto_usuario> _list_Producto_usuario = new Vector<Producto_usuario>();

	public Productos_Usuario(List<Producto_usuario> list) {
		for (Producto_usuario producto_usuario : list) {
			this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
}