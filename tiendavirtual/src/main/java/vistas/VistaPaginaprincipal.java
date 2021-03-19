package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-paginaprincipal template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-paginaprincipal")
@JsModule("./src/vista-paginaprincipal.js")
public class VistaPaginaprincipal extends PolymerTemplate<VistaPaginaprincipal.VistaPaginaprincipalModel> {

    /**
     * Creates a new VistaPaginaprincipal.
     */
    public VistaPaginaprincipal() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPaginaprincipal and vista-paginaprincipal
     */
    public interface VistaPaginaprincipalModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
