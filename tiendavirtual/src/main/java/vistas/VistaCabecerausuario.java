package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Div;

/**
 * A Designer generated component for the vista-cabecerausuario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cabecerausuario")
@JsModule("./src/vista-cabecerausuario.js")
public class VistaCabecerausuario extends PolymerTemplate<VistaCabecerausuario.VistaCabecerausuarioModel> {

    public Button getCarritoButton() {
		return carritoButton;
	}

	public void setCarritoButton(Button carritoButton) {
		this.carritoButton = carritoButton;
	}

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("horizontalIzq")
	private HorizontalLayout horizontalIzq;
	
	@Id("horizontalDerecha")
	private HorizontalLayout horizontalDerecha;
	@Id("busquedaText")
	private TextField busquedaText;
	@Id("micuentaButton")
	private Button micuentaButton;
	@Id("registrarseButton")
	private Button registrarseButton;
	@Id("iniciarSesionButton")
	private Button iniciarSesionButton;
	public HorizontalLayout getHorizontalTitulo() {
		return horizontalTitulo;
	}

	public void setHorizontalTitulo(HorizontalLayout horizontalTitulo) {
		this.horizontalTitulo = horizontalTitulo;
	}

	public Div getDivLogo() {
		return divLogo;
	}

	public void setDivLogo(Div divLogo) {
		this.divLogo = divLogo;
	}

	public Element getVerticalLogo() {
		return verticalLogo;
	}

	public void setVerticalLogo(Element verticalLogo) {
		this.verticalLogo = verticalLogo;
	}

	public Label getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(Label labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getHorizontalIzq() {
		return horizontalIzq;
	}

	public void setHorizontalIzq(HorizontalLayout horizontalIzq) {
		this.horizontalIzq = horizontalIzq;
	}

	public HorizontalLayout getHorizontalDerecha() {
		return horizontalDerecha;
	}

	public void setHorizontalDerecha(HorizontalLayout horizontalDerecha) {
		this.horizontalDerecha = horizontalDerecha;
	}

	public TextField getBusquedaText() {
		return busquedaText;
	}

	public void setBusquedaText(TextField busquedaText) {
		this.busquedaText = busquedaText;
	}

	public Button getMicuentaButton() {
		return micuentaButton;
	}

	public void setMicuentaButton(Button micuentaButton) {
		this.micuentaButton = micuentaButton;
	}

	public Button getRegistrarseButton() {
		return registrarseButton;
	}

	public void setRegistrarseButton(Button registrarseButton) {
		this.registrarseButton = registrarseButton;
	}

	public Button getIniciarSesionButton() {
		return iniciarSesionButton;
	}

	public void setIniciarSesionButton(Button iniciarSesionButton) {
		this.iniciarSesionButton = iniciarSesionButton;
	}

	public Button getCerrarSesionButton() {
		return cerrarSesionButton;
	}

	public void setCerrarSesionButton(Button cerrarSesionButton) {
		this.cerrarSesionButton = cerrarSesionButton;
	}

	@Id("cerrarSesionButton")
	private Button cerrarSesionButton;
	@Id("verticalLogo")
	private Element verticalLogo;
	@Id("labelTitulo")
	private Label labelTitulo;
	@Id("divLogo")
	private Div divLogo;
	@Id("horizontalTitulo")
	private HorizontalLayout horizontalTitulo;
	@Id("carritoButton")
	private Button carritoButton;
	/**
     * Creates a new VistaCabecerausuario.
     */
    public VistaCabecerausuario() {
        // You can initialise any data required for the connected UI components here.
	    labelTitulo.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");

    }

    /**
     * This model binds properties between VistaCabecerausuario and vista-cabecerausuario
     */
    public interface VistaCabecerausuarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
