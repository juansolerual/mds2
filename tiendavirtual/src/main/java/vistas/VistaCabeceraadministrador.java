package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-cabeceraadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cabeceraadministrador")
@JsModule("./src/vista-cabeceraadministrador.js")
public class VistaCabeceraadministrador extends PolymerTemplate<VistaCabeceraadministrador.VistaCabeceraadministradorModel> {

    /**
     * Creates a new VistaCabeceraadministrador.
     */
    public VistaCabeceraadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCabeceraadministrador and vista-cabeceraadministrador
     */
    public interface VistaCabeceraadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
