package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-elementos_comunes_carrito template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-elementos_comunes_carrito")
@JsModule("./src/vista-elementos_comunes_carrito.js")
public class VistaElementos_comunes_carrito extends PolymerTemplate<VistaElementos_comunes_carrito.VistaElementos_comunes_carritoModel> {

    /**
     * Creates a new VistaElementos_comunes_carrito.
     */
    public VistaElementos_comunes_carrito() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaElementos_comunes_carrito and vista-elementos_comunes_carrito
     */
    public interface VistaElementos_comunes_carritoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
