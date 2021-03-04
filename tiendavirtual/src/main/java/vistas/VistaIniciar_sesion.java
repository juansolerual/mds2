package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;

/**
 * A Designer generated component for the vista-iniciar_sesion template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-iniciar_sesion")
@JsModule("./src/vista-iniciar_sesion.js")
public class VistaIniciar_sesion extends PolymerTemplate<VistaIniciar_sesion.VistaIniciar_sesionModel> {

    @Id("password")
	private PasswordField password;
	@Id("loginGoogle")
	private Button loginGoogle;
	@Id("loginFacebook")
	private Button loginFacebook;
	@Id("vaadinLoginForm")
	private LoginForm vaadinLoginForm;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaIniciar_sesion.
     */
    public VistaIniciar_sesion() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaIniciar_sesion and vista-iniciar_sesion
     */
    public interface VistaIniciar_sesionModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public Button getLoginGoogle() {
		return loginGoogle;
	}

	public void setLoginGoogle(Button loginGoogle) {
		this.loginGoogle = loginGoogle;
	}

	public Button getLoginFacebook() {
		return loginFacebook;
	}

	public void setLoginFacebook(Button loginFacebook) {
		this.loginFacebook = loginFacebook;
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
