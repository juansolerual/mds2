package interfaz;

import java.util.List;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Producto;
import basededatos.iAdmin;
import interfaz.Producto_administrador;

public class Lista_productos_admin extends VerticalLayout {
	public Vista_producto_Admin _vista_producto_Admin;
	public List<Producto> _list_Producto_administrador;
	public Lista_productos_admin() {
		super();
		iAdmin adm = new BDPrincipal();

		_list_Producto_administrador = adm.cargarProductos();
	}
	
}