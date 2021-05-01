package interfaz;

import vistas.VistaCabeceraadministrador;

public class Cabecera_encargado_compras extends VistaCabeceraadministrador{
	public Cabecera_encargado_compras() {
		super();
		this.getMiCuentaButton().setText("Encargado de compras");
		this.getBarraBusqueda().setPlaceholder("Búsqueda por cliente o número de pedido");
		
	}
	public Vista_listado_de_compras _vista_listado_de_compras;
	public Accede_cuenta_encargado_compras _accede_cuenta_encargado_compras;
	public Barra_busqueda_encargado_compras _barra_busqueda_encargado_compras;
	public Cerrar_sesion_encargado_compras _cerrar_sesion_encargado_compras;
}