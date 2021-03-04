package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-producto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-producto")
@JsModule("./src/vista-producto.js")
public class VistaProducto extends PolymerTemplate<VistaProducto.VistaProductoModel> {

    @Id("vaadinItem")
	private Element vaadinItem;
	@Id("img")
	private Image img;
	
	@Id("anadirCarrito")
	private Button anadirCarrito;
	@Id("editarProducto")
	private Button editarProducto;
	/**
     * Creates a new VistaProducto.
     */
    public VistaProducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProducto and vista-producto
     */
    public interface VistaProductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
