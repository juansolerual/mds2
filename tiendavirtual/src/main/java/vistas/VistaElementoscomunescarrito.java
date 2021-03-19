package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-elementoscomunescarrito template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-elementoscomunescarrito")
@JsModule("./src/vista-elementoscomunescarrito.js")
public class VistaElementoscomunescarrito extends PolymerTemplate<VistaElementoscomunescarrito.VistaElementoscomunescarritoModel> {

    /**
     * Creates a new VistaElementoscomunescarrito.
     */
    public VistaElementoscomunescarrito() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaElementoscomunescarrito and vista-elementoscomunescarrito
     */
    public interface VistaElementoscomunescarritoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
