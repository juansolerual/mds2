package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-busqueda template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-busqueda")
@JsModule("./src/vista-busqueda.js")
public class VistaBusqueda extends PolymerTemplate<VistaBusqueda.VistaBusquedaModel> {

    @Id("barraIzquierda")
	private Element barraIzquierda;
	@Id("barraDerecha")
	private Element barraDerecha;

	/**
     * Creates a new VistaBusqueda.
     */
    public VistaBusqueda() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaBusqueda and vista-busqueda
     */
    public interface VistaBusquedaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getBarraIzquierda() {
		return barraIzquierda;
	}

	public void setBarraIzquierda(Element barraIzquierda) {
		this.barraIzquierda = barraIzquierda;
	}

	public Element getBarraDerecha() {
		return barraDerecha;
	}

	public void setBarraDerecha(Element barraDerecha) {
		this.barraDerecha = barraDerecha;
	}
}
