package interfaz;

public class Vista_carrito_Usuario_no_registrado extends Elementos_comunes_carrito {
	public Usuario_no_identificado _usuario_no_identificado;

	public Vista_carrito_Usuario_no_registrado() {
		super();
		this.realizarPago.setEnabled(false);
		this.terminarPedido.setEnabled(false);
	}
	
}