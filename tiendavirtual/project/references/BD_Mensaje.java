package basededatos;

import java.util.Vector;
import basededatos.Mensaje;

public class BD_Mensaje {
	public BDPrincipal _bDPrincipal;
	public Vector<Mensaje> _contiene_mensajes = new Vector<Mensaje>();

	public Mensaje[] cargarMensajesRecibidos(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public Mensaje[] cargarMensajesEnviados(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean enviarMensaje(Mensaje aMensaje) {
		throw new UnsupportedOperationException();
	}

	public Mensaje abrirMensaje(int aIdMensaje) {
		throw new UnsupportedOperationException();
	}
}