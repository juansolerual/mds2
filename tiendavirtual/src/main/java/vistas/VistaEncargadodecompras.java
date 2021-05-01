package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-encargadodecompras template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-encargadodecompras")
@JsModule("./src/vista-encargadodecompras.js")
public class VistaEncargadodecompras extends PolymerTemplate<VistaEncargadodecompras.VistaEncargadodecomprasModel> {

    public Element getVerticalLayoutEncargado() {
		return verticalLayoutEncargado;
	}

	public void setVerticalLayoutEncargado(Element verticalLayoutEncargado) {
		this.verticalLayoutEncargado = verticalLayoutEncargado;
	}

	@Id("verticalLayoutEncargado")
	private Element verticalLayoutEncargado;

	/**
     * Creates a new VistaEncargadodecompras.
     */
    public VistaEncargadodecompras() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEncargadodecompras and vista-encargadodecompras
     */
    public interface VistaEncargadodecomprasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
