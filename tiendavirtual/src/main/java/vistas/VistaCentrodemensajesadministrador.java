package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-centrodemensajesadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-centrodemensajesadministrador")
@JsModule("./src/vista-centrodemensajesadministrador.js")
public class VistaCentrodemensajesadministrador extends PolymerTemplate<VistaCentrodemensajesadministrador.VistaCentrodemensajesadministradorModel> {

    /**
     * Creates a new VistaCentrodemensajesadministrador.
     */
    public VistaCentrodemensajesadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCentrodemensajesadministrador and vista-centrodemensajesadministrador
     */
    public interface VistaCentrodemensajesadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
