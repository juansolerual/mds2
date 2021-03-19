package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-cabecera_usuario_registrado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cabecera_usuario_registrado")
@JsModule("./src/vista-cabecera_usuario_registrado.js")
public class VistaCabecera_usuario_registrado extends PolymerTemplate<VistaCabecera_usuario_registrado.VistaCabecera_usuario_registradoModel> {

    /**
     * Creates a new VistaCabecera_usuario_registrado.
     */
    public VistaCabecera_usuario_registrado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCabecera_usuario_registrado and vista-cabecera_usuario_registrado
     */
    public interface VistaCabecera_usuario_registradoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
