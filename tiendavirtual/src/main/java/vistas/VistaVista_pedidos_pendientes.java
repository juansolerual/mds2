package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-vista_pedidos_pendientes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vista_pedidos_pendientes")
@JsModule("./src/vista-vista_pedidos_pendientes.js")
public class VistaVista_pedidos_pendientes extends PolymerTemplate<VistaVista_pedidos_pendientes.VistaVista_pedidos_pendientesModel> {

    /**
     * Creates a new VistaVista_pedidos_pendientes.
     */
    public VistaVista_pedidos_pendientes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVista_pedidos_pendientes and vista-vista_pedidos_pendientes
     */
    public interface VistaVista_pedidos_pendientesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
