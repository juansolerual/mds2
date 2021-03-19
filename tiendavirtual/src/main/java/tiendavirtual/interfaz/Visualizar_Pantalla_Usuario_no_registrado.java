package tiendavirtual.interfaz;

public class Visualizar_Pantalla_Usuario_no_registrado extends Visualizar_Pantalla {
	public Usuario_no_identificado _usuario_no_identificado;

	public Visualizar_Pantalla_Usuario_no_registrado() {
		super();
		_productos_Usuario = new Productos_Usuario();
		horizontalLayout.addComponentAsFirst(_productos_Usuario);

	}
	
	
}