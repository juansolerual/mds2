package interfaz;

public class Cabecera_Usuario_No_Registrado extends Cabecera_Usuario{
	public Usuario_no_identificado usuario_no_identificado;

	public Cabecera_Usuario_No_Registrado() {
		super();
		this.getCerrarSesionButton().setVisible(false);
		this.getMicuentaButton().setVisible(false);
	}
	
}
