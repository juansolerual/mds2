package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-iniciarsesion template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-iniciarsesion")
@JsModule("./src/vista-iniciarsesion.js")
public class VistaIniciarsesion extends PolymerTemplate<VistaIniciarsesion.VistaIniciarsesionModel> {

    @Id("vaadinLoginForm")
	private LoginForm vaadinLoginForm;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaIniciarsesion.
     */
    public VistaIniciarsesion() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaIniciarsesion and vista-iniciarsesion
     */
    public interface VistaIniciarsesionModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public LoginForm getVaadinLoginForm() {
		return vaadinLoginForm;
	}

	public void setVaadinLoginForm(LoginForm vaadinLoginForm) {
		this.vaadinLoginForm = vaadinLoginForm;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
