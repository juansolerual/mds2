package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-app_transportes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-app_transportes")
@JsModule("./src/vista-app_transportes.js")
public class VistaApp_transportes extends PolymerTemplate<VistaApp_transportes.VistaApp_transportesModel> {

    /**
     * Creates a new VistaApp_transportes.
     */
    public VistaApp_transportes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaApp_transportes and vista-app_transportes
     */
    public interface VistaApp_transportesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
