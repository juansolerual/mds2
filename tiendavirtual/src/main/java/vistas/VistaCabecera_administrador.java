package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-cabecera_administrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cabecera_administrador")
@JsModule("./src/vista-cabecera_administrador.js")
public class VistaCabecera_administrador extends PolymerTemplate<VistaCabecera_administrador.VistaCabecera_administradorModel> {

    /**
     * Creates a new VistaCabecera_administrador.
     */
    public VistaCabecera_administrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCabecera_administrador and vista-cabecera_administrador
     */
    public interface VistaCabecera_administradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
