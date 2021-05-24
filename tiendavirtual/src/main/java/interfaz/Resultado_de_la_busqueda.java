package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import basededatos.Producto;
import interfaz.Producto_busqueda;

public class Resultado_de_la_busqueda {
	public Vista_busqueda_de_productos_categorias _vista_busqueda_de_productos_categorias;

	public List<Producto> _list_Producto_busqueda;

	public Resultado_de_la_busqueda(List<Producto> _list_Producto_busqueda) {
		super();
		this._list_Producto_busqueda = _list_Producto_busqueda;
	}
	
}