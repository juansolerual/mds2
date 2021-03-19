package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-listadodecompras template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listadodecompras")
@JsModule("./src/vista-listadodecompras.js")
public class VistaListadodecompras extends PolymerTemplate<VistaListadodecompras.VistaListadodecomprasModel> {

    /**
     * Creates a new VistaListadodecompras.
     */
    public VistaListadodecompras() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListadodecompras and vista-listadodecompras
     */
    public interface VistaListadodecomprasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
