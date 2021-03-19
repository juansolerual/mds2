package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-anuncio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-anuncio")
@JsModule("./src/vista-anuncio.js")
public class VistaAnuncio extends PolymerTemplate<VistaAnuncio.VistaAnuncioModel> {

    /**
     * Creates a new VistaAnuncio.
     */
    public VistaAnuncio() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAnuncio and vista-anuncio
     */
    public interface VistaAnuncioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
