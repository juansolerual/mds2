package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import interfaz.Categoria_admin;

public class Lista_categorias  extends VerticalLayout{
	public Vista_Categoria_Admin _vista_Categoria_Admin;
	public Vector<Categoria_admin> _list_Categoria_admin = new Vector<Categoria_admin>();
	
	public Lista_categorias() {
		super();
	}
	
}