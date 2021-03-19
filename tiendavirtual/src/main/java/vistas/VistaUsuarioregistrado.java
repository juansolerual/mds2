package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-usuarioregistrado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-usuarioregistrado")
@JsModule("./src/vista-usuarioregistrado.js")
public class VistaUsuarioregistrado extends PolymerTemplate<VistaUsuarioregistrado.VistaUsuarioregistradoModel> {

	public Element getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(Element verticalLayout) {
		this.verticalLayout = verticalLayout;
	}

	@Id("verticalLayout")
	private Element verticalLayout;
	
    /**
     * Creates a new VistaUsuarioregistrado.
     */
    public VistaUsuarioregistrado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaUsuarioregistrado and vista-usuarioregistrado
     */
    public interface VistaUsuarioregistradoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
