package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-anuncios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-anuncios")
@JsModule("./src/vista-anuncios.js")
public class VistaAnuncios extends PolymerTemplate<VistaAnuncios.VistaAnunciosModel> {

    /**
     * Creates a new VistaAnuncios.
     */
    public VistaAnuncios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAnuncios and vista-anuncios
     */
    public interface VistaAnunciosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
