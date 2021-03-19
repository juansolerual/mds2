package tiendavirtual.interfaz;

import vistas.VistaElementoscomunespantallaprincipal;

public class Elementos_comunes_pantalla_principal extends VistaElementoscomunespantallaprincipal{
	public Ofertas _ofertas;
	public Categorias _categorias;
	public Anuncios _anuncios;
	
	//public Productos_Usuario _productos_usuario;

	
	public Elementos_comunes_pantalla_principal() {
		super();
		_categorias = new Categorias();
		_ofertas = new Ofertas();
		
		// this._productos_administrador._visualizar_Pantalla_Principal_Administrador.setVisible(false);
		// this._productos_usuario._visualizar_Pantalla_Principal_Usuario_Registrado.setVisible(false);
		
		
		
	}

	public Ofertas get_ofertas() {
		return _ofertas;
	}

	public void set_ofertas(Ofertas _ofertas) {
		this._ofertas = _ofertas;
	}

	public Categorias get_categorias() {
		return _categorias;
	}

	public void set_categorias(Categorias _categorias) {
		this._categorias = _categorias;
	}

	public Anuncios get_anuncios() {
		return _anuncios;
	}

	public void set_anuncios(Anuncios _anuncios) {
		this._anuncios = _anuncios;
	}
	
	
}