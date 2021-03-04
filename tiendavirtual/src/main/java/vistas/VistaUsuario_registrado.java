package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-usuario_registrado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-usuario_registrado")
@JsModule("./src/vista-usuario_registrado.js")
public class VistaUsuario_registrado extends PolymerTemplate<VistaUsuario_registrado.VistaUsuario_registradoModel> {

    /**
     * Creates a new VistaUsuario_registrado.
     */
    public VistaUsuario_registrado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaUsuario_registrado and vista-usuario_registrado
     */
    public interface VistaUsuario_registradoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
