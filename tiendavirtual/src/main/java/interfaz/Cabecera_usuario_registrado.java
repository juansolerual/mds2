package interfaz;

public class Cabecera_usuario_registrado extends Cabecera_Usuario{
	private event _cerrar_sesion;
	public Usuario_registrado _usuario_registrado;
	//public Barra_busqueda_usuario_registrado _barra_busqueda_usuario_registrado;
	//public Boton_acceder_mi_cuenta _boton_acceder_mi_cuenta;

	public void Cerrar_sesion() {
		throw new UnsupportedOperationException();
	}
	public Cabecera_usuario_registrado() {
		super();
		this.getIniciarSesionButton().setVisible(false);
		this.getRegistrarseButton().setVisible(false);
	}
}