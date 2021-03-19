package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-apptransportes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-apptransportes")
@JsModule("./src/vista-apptransportes.js")
public class VistaApptransportes extends PolymerTemplate<VistaApptransportes.VistaApptransportesModel> {

    /**
     * Creates a new VistaApptransportes.
     */
    public VistaApptransportes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaApptransportes and vista-apptransportes
     */
    public interface VistaApptransportesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
