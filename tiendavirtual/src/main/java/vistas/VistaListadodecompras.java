package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-listadodecompras template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listadodecompras")
@JsModule("./src/vista-listadodecompras.js")
public class VistaListadodecompras extends PolymerTemplate<VistaListadodecompras.VistaListadodecomprasModel> {

    @Id("barraDerecha")
	private Element barraDerecha;
	@Id("barraIzquierda")
	private Element barraIzquierda;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaListadodecompras.
     */
    public VistaListadodecompras() {
        // You can initialise any data required for the connected UI components here.
    }

    public Element getBarraDerecha() {
		return barraDerecha;
	}

	public void setBarraDerecha(Element barraDerecha) {
		this.barraDerecha = barraDerecha;
	}

	public Element getBarraIzquierda() {
		return barraIzquierda;
	}

	public void setBarraIzquierda(Element barraIzquierda) {
		this.barraIzquierda = barraIzquierda;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	/**
     * This model binds properties between VistaListadodecompras and vista-listadodecompras
     */
    public interface VistaListadodecomprasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
