package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-registrarse template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-registrarse")
@JsModule("./src/vista-registrarse.js")
public class VistaRegistrarse extends PolymerTemplate<VistaRegistrarse.VistaRegistrarseModel> {

    @Id("nombre")
	private TextField nombre;
	@Id("password")
	private PasswordField password;
	@Id("email")
	private TextField email;
	@Id("apellidos")
	private TextField apellidos;
	@Id("password2")
	private PasswordField password2;
	@Id("registrarseButton")
	private Button vaadinButton;
	@Id("registrarseButton")
	private Button registrarseButton;
	/**
     * Creates a new VistaRegistrarse.
     */
    public VistaRegistrarse() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaRegistrarse and vista-registrarse
     */
    public interface VistaRegistrarseModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
