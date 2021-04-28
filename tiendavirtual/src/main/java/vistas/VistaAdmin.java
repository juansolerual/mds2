package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-admin template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-admin")
@JsModule("./src/vista-admin.js")
public class VistaAdmin extends PolymerTemplate<VistaAdmin.VistaAdminModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaAdmin.
     */
    public VistaAdmin() {
        // You can initialise any data required for the connected UI components here.
    }

    public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	/**
     * This model binds properties between VistaAdmin and vista-admin
     */
    public interface VistaAdminModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
