package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-vista_listado_de_compras template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vista_listado_de_compras")
@JsModule("./src/vista-vista_listado_de_compras.js")
public class VistaVista_listado_de_compras extends PolymerTemplate<VistaVista_listado_de_compras.VistaVista_listado_de_comprasModel> {

    /**
     * Creates a new VistaVista_listado_de_compras.
     */
    public VistaVista_listado_de_compras() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVista_listado_de_compras and vista-vista_listado_de_compras
     */
    public interface VistaVista_listado_de_comprasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
