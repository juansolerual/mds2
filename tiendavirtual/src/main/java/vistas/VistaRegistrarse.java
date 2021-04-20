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
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.select.Select;

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
	@Id("password2")
	private PasswordField password2;
	@Id("registrarseButton")
	private Button registrarseButton;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	public TextField getNombre() {
		return nombre;
	}

	public void setNombre(TextField nombre) {
		this.nombre = nombre;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public PasswordField getPassword2() {
		return password2;
	}

	public void setPassword2(PasswordField password2) {
		this.password2 = password2;
	}

	public Button getRegistrarseButton() {
		return registrarseButton;
	}

	public void setRegistrarseButton(Button registrarseButton) {
		this.registrarseButton = registrarseButton;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Select getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(Select formaDePago) {
		this.formaDePago = formaDePago;
	}

	public TextField getEmail() {
		return email;
	}

	public void setEmail(TextField email) {
		this.email = email;
	}

	public Label getLabelFotoPerfil() {
		return labelFotoPerfil;
	}

	public void setLabelFotoPerfil(Label labelFotoPerfil) {
		this.labelFotoPerfil = labelFotoPerfil;
	}

	public Label getLabelRegistroUsuario() {
		return labelRegistroUsuario;
	}

	public void setLabelRegistroUsuario(Label labelRegistroUsuario) {
		this.labelRegistroUsuario = labelRegistroUsuario;
	}

	public Button getSeleccionarFotoButton() {
		return seleccionarFotoButton;
	}

	public void setSeleccionarFotoButton(Button seleccionarFotoButton) {
		this.seleccionarFotoButton = seleccionarFotoButton;
	}

	public TextField getDireccion() {
		return direccion;
	}

	public void setDireccion(TextField direccion) {
		this.direccion = direccion;
	}

	public TextField getApellidos() {
		return apellidos;
	}

	public void setApellidos(TextField apellidos) {
		this.apellidos = apellidos;
	}

	@Id("img")
	private Image img;
	@Id("formaDePago")
	private Select formaDePago;
	@Id("email")
	private TextField email;
	@Id("labelFotoPerfil")
	private Label labelFotoPerfil;
	@Id("labelRegistroUsuario")
	private Label labelRegistroUsuario;
	@Id("seleccionarFotoButton")
	private Button seleccionarFotoButton;
	@Id("direccion")
	private TextField direccion;
	@Id("apellidos")
	private TextField apellidos;
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
