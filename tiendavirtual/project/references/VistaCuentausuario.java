package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-cuentausuario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cuentausuario")
@JsModule("./src/vista-cuentausuario.js")
public class VistaCuentausuario extends PolymerTemplate<VistaCuentausuario.VistaCuentausuarioModel> {

    @Id("barraIzquierda")
	private Element barraIzquierda;
	@Id("barraDerecha")
	private Element barraDerecha;

	/**
     * Creates a new VistaCuentausuario.
     */
    public VistaCuentausuario() {
        // You can initialise any data required for the connected UI components here.
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

	/**
     * This model binds properties between VistaCuentausuario and vista-cuentausuario
     */
    public interface VistaCuentausuarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
