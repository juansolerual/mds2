package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the vista-vista_pagina_principal template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vista_pagina_principal")
@JsModule("./src/vista-vista_pagina_principal.js")
public class VistaVista_pagina_principal extends PolymerTemplate<VistaVista_pagina_principal.VistaVista_pagina_principalModel> {

    /**
     * Creates a new VistaVista_pagina_principal.
     */
    public VistaVista_pagina_principal() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVista_pagina_principal and vista-vista_pagina_principal
     */
    public interface VistaVista_pagina_principalModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
