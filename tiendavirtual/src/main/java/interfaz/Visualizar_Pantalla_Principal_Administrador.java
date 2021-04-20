package interfaz;

public class Visualizar_Pantalla_Principal_Administrador extends Visualizar_Pantalla {
	public Admin _admin;
	public Productos_Administrador _productos_administrador;
	//public Acceder_a_cuenta_admin _acceder_a_cuenta_admin;
	public Visualizar_Pantalla_Principal_Administrador() {
		super();
		
		this.horizontalLayout.removeAll();
		this.horizontalLayout.add(_productos_administrador);
		this.horizontalLayout.add(_elementos_comunes_pantalla_principal.get_categorias());

	}
	
}