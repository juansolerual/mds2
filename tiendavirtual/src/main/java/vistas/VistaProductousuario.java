package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;

import basededatos.Producto;
import interfaz.Producto_usuario;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.select.Select;

/**
 * A Designer generated component for the vista-producto_usuario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productousuario")
@JsModule("./src/vista-productousuario.js")
public class VistaProductousuario extends PolymerTemplate<VistaProductousuario.VistaProductousuarioModel> {

   

	

	

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("fotos")
	private HorizontalLayout fotos;
	@Id("image1")
	private Image image1;
	@Id("image2")
	private Image image2;
	@Id("image3")
	private Image image3;
	@Id("image4")
	private Image image4;
	@Id("image5")
	private Image image5;
	@Id("precio")
	private TextField precio;
	@Id("addCarritoButton")
	private Button addCarritoButton;
	@Id("cantidad")
	private Select cantidad;
	@Id("descripcion")
	private HorizontalLayout descripcion;
	@Id("caracteristicas")
	private HorizontalLayout caracteristicas;
	@Id("valoraciones")
	private HorizontalLayout valoraciones;

	/**
     * Creates a new VistaProducto_usuario.
     */
    public VistaProductousuario(Producto producto) {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProducto_usuario and vista-producto_usuario
     */
    public interface VistaProductousuarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
