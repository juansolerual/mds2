package interfaz;

import java.util.Vector;

import org.hibernate.transform.AliasToEntityMapResultTransformer;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.iAdmin;
import interfaz.Categoria;
import vistas.VistaCategorias;
import vistas.VistaProductousuario;

public class Categorias extends VistaCategorias {
	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	public VaadinSession session = VaadinSession.getCurrent();

	// public Vector<Categoria> _list_Categoria = new Vector<Categoria>();

	// public cargarCategorias...

	public Categorias() {

		String user = (String) session.getAttribute("username");
		HorizontalLayout scrollableLayout = new HorizontalLayout();
		for (int i = 0; i < 50; i++) {
			scrollableLayout.add(new Categoria());
		}
		// Give the layout a defined height that fits the parent layout
		scrollableLayout.setHeight("100%");
		scrollableLayout.setWidth(null);
		// Set overflow on the y-axis to "auto".
		// It can be also "scroll", but then you
		// have a scroll bar even when one isn't needed.
		scrollableLayout.getStyle().set("overflow-x", "auto").set("margin-left", "20px").set("margin-right", "20px");
		// Another element to show that it stays in the same place
		Label staticElement = new Label("Categoria destacados");
		staticElement.getStyle().set("color", "blue").set("font-weight", "bold").set("margin", "20px");
		
		Dialog dialog = new Dialog();
		HorizontalLayout dialogHorizontal = new HorizontalLayout();
		Label tituloDialog = new Label("Nueva categoría");
		dialogHorizontal.add(tituloDialog);
		dialog.setWidth("800px");
		dialog.setHeight("600px");
		dialog.setMinHeight("600px");
		dialog.setMinWidth("800px");
		
		dialog.setModal(false);
		dialog.setDraggable(true);
		dialog.setResizable(true);
		//dialog.add(new Text("Close me with the esc-key or an outside click"));
		TextField nombreCategoria = new TextField("Nombre categoría:");
		nombreCategoria.getStyle().set("margin", "20px").set("width", "400px");
		
		TextField descripcion = new TextField("Descripción:");
		descripcion.getStyle().set("margin", "20px").set("width", "400px");

		Button guardar = new Button("Guardar");
		guardar.getStyle().set("margin", "20px");
		
		Button cancelButton = new Button("Cancelar", event -> {
		    dialog.close();
		});
		cancelButton.getStyle().set("margin", "20px");

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialog, () -> {
		    dialog.close();
		}, Key.ESCAPE);
		
		guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				basededatos.Categoria aCategoria = new basededatos.Categoria();
				aCategoria.setNombreCategoria(nombreCategoria.getValue());
				aCategoria.setDescripcion(descripcion.getValue());
				int result = adm.guardarCategoria(aCategoria);
				if(result != -1) {
					Notification notification =  Notification.show(
					        "La categoría ha sido creada correctamente", 3000,
					        Position.MIDDLE);
					nombreCategoria.setValue("");
					descripcion.setValue("");
					dialog.close();
				}else {
					Notification notification =  Notification.show(
					        "Ha habido un error. Inténtalo de nuevo.", 3000,
					        Position.TOP_CENTER);
				}
			}
			
		});
		VerticalLayout dialogVertical = new VerticalLayout(nombreCategoria, descripcion);
		HorizontalLayout dialogButtons = new HorizontalLayout(guardar, cancelButton);
		dialogHorizontal.getStyle().set("margin", "20px").set("width", "100%");
		dialogVertical.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageEsc = new Label("o pulsa ESC para salir");

		dialog.add(dialogHorizontal, dialogVertical, dialogButtons, mesageEsc);
		

		
		Button nuevoCategoria = new Button("+");
		nuevoCategoria.getElement().getStyle().set("margin-left", "auto");
		nuevoCategoria.addClickListener(event -> dialog.open());

		/*
		 * nuevoCategoria.addClickListener(new
		 * ComponentEventListener<ClickEvent<Button>>() {
		 * 
		 * @Override public void onComponentEvent(ClickEvent<Button> event) { // TODO
		 * Auto-generated method stub HorizontalLayout horizontalLayoutAdministrador =
		 * (HorizontalLayout) session .getAttribute("horizontalLayoutAdministrador");
		 * 
		 * horizontalLayoutAdministrador.removeAll();
		 * 
		 * Visualizar_Pantalla_Principal_Administrador
		 * _visualizar_Pantalla_Principal_Administrador =
		 * (Visualizar_Pantalla_Principal_Administrador) session
		 * .getAttribute("visualizar_Pantalla_Principal_Administrador");
		 * 
		 * VerticalLayout verticalLayoutAdmin = (VerticalLayout)
		 * session.getAttribute("verticalLayoutAdmin");
		 * verticalLayoutAdmin.remove(_visualizar_Pantalla_Principal_Administrador);
		 * 
		 * VistaProductousuario vistaProductoUsuario = new VistaProductousuario(null,
		 * true); verticalLayoutAdmin.add(vistaProductoUsuario); }
		 * 
		 * });
		 */

		nuevoCategoria.setVisible(false);
		if (user != null) {
			nuevoCategoria.setVisible(user.equals("admin"));
		}
		HorizontalLayout primeraLinea = new HorizontalLayout();
		primeraLinea.setPadding(true);
		primeraLinea.add(staticElement, nuevoCategoria);
		primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");

		// Add both the scrollable layout and
		// the static element to the layout
		this.getHorizontalLayout().add(primeraLinea, scrollableLayout);
		this.getHorizontalLayout().getStyle().set("border", "2px solid blue").set("border-radius", "25px");

	}

}