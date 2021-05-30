package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Div;

/**
 * A Designer generated component for the vista-cabeceraadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cabeceraadministrador")
@JsModule("./src/vista-cabeceraadministrador.js")
public class VistaCabeceraadministrador extends PolymerTemplate<VistaCabeceraadministrador.VistaCabeceraadministradorModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	public Div getDivLogo() {
		return divLogo;
	}

	public void setDivLogo(Div divLogo) {
		this.divLogo = divLogo;
	}

	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("label")
	private Label label;
	@Id("vaadinVerticalLayout1")
	private Element vaadinVerticalLayout1;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("barraBusqueda")
	private TextField barraBusqueda;
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

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Element getVaadinVerticalLayout1() {
		return vaadinVerticalLayout1;
	}

	public void setVaadinVerticalLayout1(Element vaadinVerticalLayout1) {
		this.vaadinVerticalLayout1 = vaadinVerticalLayout1;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public TextField getBarraBusqueda() {
		return barraBusqueda;
	}

	public void setBarraBusqueda(TextField barraBusqueda) {
		this.barraBusqueda = barraBusqueda;
	}

	public Button getMiCuentaButton() {
		return miCuentaButton;
	}

	public void setMiCuentaButton(Button miCuentaButton) {
		this.miCuentaButton = miCuentaButton;
	}

	public HorizontalLayout getVaadinHorizontalLayout2() {
		return vaadinHorizontalLayout2;
	}

	public void setVaadinHorizontalLayout2(HorizontalLayout vaadinHorizontalLayout2) {
		this.vaadinHorizontalLayout2 = vaadinHorizontalLayout2;
	}

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}

	public Button getCerrarSesion() {
		return cerrarSesion;
	}

	public void setCerrarSesion(Button cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}

	@Id("miCuentaButton")
	private Button miCuentaButton;
	@Id("vaadinHorizontalLayout2")
	private HorizontalLayout vaadinHorizontalLayout2;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("cerrarSesion")
	private Button cerrarSesion;
	@Id("divLogo")
	private Div divLogo;

	/**
     * Creates a new VistaCabeceraadministrador.
     */
    public VistaCabeceraadministrador() {
        // You can initialise any data required for the connected UI components here.
	    label.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "#1676f3");

    }

    /**
     * This model binds properties between VistaCabeceraadministrador and vista-cabeceraadministrador
     */
    public interface VistaCabeceraadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
