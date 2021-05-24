package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.iEncargado_de_compras;
import interfaz.Producto_Carrito;
import tiendavirtual.cookiesHelper;

public class Lista_elementos_carrito {
	private event _eliminar_Producto_del_carrito;
	private event _modificar_cantidad_unidades;
	public Elementos_comunes_carrito _elementos_comunes_carrito;
	//public Vector<Producto_Carrito> _list_Producto_Carrito = new Vector<Producto_Carrito>();
	
	public List<Lineas_de_Pedido> carrito;


	public Lista_elementos_carrito() {
		super();

		VaadinSession session = VaadinSession.getCurrent();

		if (cookiesHelper.isNoRegistrado()) {
			carrito = (List<Lineas_de_Pedido>) session.getAttribute("carrito_invitado");

		}else {
			carrito = (List<Lineas_de_Pedido>) session.getAttribute(String.valueOf(cookiesHelper.idUsuario));
		}
		
		if (carrito == null) {
			carrito = new ArrayList<Lineas_de_Pedido>();
		}
		
	}
	
	public Lista_elementos_carrito(int idPedido) {
		super();

		VaadinSession session = VaadinSession.getCurrent();

		iEncargado_de_compras encargado = new BDPrincipal();
		carrito = encargado.cargarCarrito(idPedido);
		
		if (carrito == null) {
			carrito = new ArrayList<Lineas_de_Pedido>();
		}
		
	}
	
	

	public void Eliminar_Producto_del_carrito() {
		throw new UnsupportedOperationException();
	}

	public void Modificar_cantidad_unidades() {
		throw new UnsupportedOperationException();
	}
}