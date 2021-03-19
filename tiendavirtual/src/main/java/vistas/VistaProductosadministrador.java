package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-productosadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productosadministrador")
@JsModule("./src/vista-productosadministrador.js")
public class VistaProductosadministrador extends PolymerTemplate<VistaProductosadministrador.VistaProductosadministradorModel> {

    @Id("horizontalProductos")
	private HorizontalLayout horizontalProductos;

	/**
     * Creates a new VistaProductosadministrador.
     */
    public VistaProductosadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductosadministrador and vista-productosadministrador
     */
    public interface VistaProductosadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getHorizontalProductos() {
		return horizontalProductos;
	}

	public void setHorizontalProductos(HorizontalLayout horizontalProductos) {
		this.horizontalProductos = horizontalProductos;
	}
}
