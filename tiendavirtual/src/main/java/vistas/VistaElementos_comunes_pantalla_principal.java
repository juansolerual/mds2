package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-elementos_comunes_pantalla_principal template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-elementos_comunes_pantalla_principal")
@JsModule("./src/vista-elementos_comunes_pantalla_principal.js")
public class VistaElementos_comunes_pantalla_principal extends PolymerTemplate<VistaElementos_comunes_pantalla_principal.VistaElementos_comunes_pantalla_principalModel> {

    @Id("vistaProductos_usuario")
	private Element vistaProductos_usuario;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaElementos_comunes_pantalla_principal.
     */
    public VistaElementos_comunes_pantalla_principal() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaElementos_comunes_pantalla_principal and vista-elementos_comunes_pantalla_principal
     */
    public interface VistaElementos_comunes_pantalla_principalModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
