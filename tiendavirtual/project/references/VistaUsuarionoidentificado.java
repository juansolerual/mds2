package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-usuarionoidentificado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-usuarionoidentificado")
@Route(value = "usuarionoidentificado")
@JsModule("./src/vista-usuarionoidentificado.js")
public class VistaUsuarionoidentificado extends PolymerTemplate<VistaUsuarionoidentificado.VistaUsuarionoidentificadoModel> {

    public Element getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(Element verticalLayout) {
		this.verticalLayout = verticalLayout;
	}

	@Id("verticalLayout")
	private Element verticalLayout;

	/**
     * Creates a new VistaUsuarionoidentificado.
     */
    public VistaUsuarionoidentificado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaUsuarionoidentificado and vista-usuarionoidentificado
     */
    public interface VistaUsuarionoidentificadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
