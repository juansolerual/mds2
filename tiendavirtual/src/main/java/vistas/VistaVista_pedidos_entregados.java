package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-vista_pedidos_entregados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vista_pedidos_entregados")
@JsModule("./src/vista-vista_pedidos_entregados.js")
public class VistaVista_pedidos_entregados extends PolymerTemplate<VistaVista_pedidos_entregados.VistaVista_pedidos_entregadosModel> {

    /**
     * Creates a new VistaVista_pedidos_entregados.
     */
    public VistaVista_pedidos_entregados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVista_pedidos_entregados and vista-vista_pedidos_entregados
     */
    public interface VistaVista_pedidos_entregadosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
