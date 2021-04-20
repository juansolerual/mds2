package interfaz;

import vistas.VistaIniciarsesion;

public class Iniciar_sesion extends VistaIniciarsesion{
	public Iniciar_sesion() {
			super();
			
	}

	public Usuario_no_identificado _usuario_no_identificado;
	public Recuperar_contrasena _recuperar_contrasena;
	public Inicio_sesion_con_Google _inicio_sesion_con_Google;
	public Inicio_sesion_con_Facebook _inicio_sesion_con_Facebook;

	public void Validar_inicio_sesion() {
		throw new UnsupportedOperationException();
	}
}