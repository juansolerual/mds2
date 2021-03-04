package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-usuario_no_identificado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-usuario_no_identificado")
@JsModule("./src/vista-usuario_no_identificado.js")
public class VistaUsuario_no_identificado extends PolymerTemplate<VistaUsuario_no_identificado.VistaUsuario_no_identificadoModel> {

    /**
     * Creates a new VistaUsuario_no_identificado.
     */
    public VistaUsuario_no_identificado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaUsuario_no_identificado and vista-usuario_no_identificado
     */
    public interface VistaUsuario_no_identificadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
