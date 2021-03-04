package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-encargado_de_compras template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-encargado_de_compras")
@JsModule("./src/vista-encargado_de_compras.js")
public class VistaEncargado_de_compras extends PolymerTemplate<VistaEncargado_de_compras.VistaEncargado_de_comprasModel> {

    /**
     * Creates a new VistaEncargado_de_compras.
     */
    public VistaEncargado_de_compras() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEncargado_de_compras and vista-encargado_de_compras
     */
    public interface VistaEncargado_de_comprasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
