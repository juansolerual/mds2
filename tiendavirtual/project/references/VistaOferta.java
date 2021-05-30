package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-oferta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-oferta")
@JsModule("./src/vista-oferta.js")
public class VistaOferta extends PolymerTemplate<VistaOferta.VistaOfertaModel> {

    @Id("verticalLayout")
	private VerticalLayout verticalLayout;

	/**
     * Creates a new VistaOferta.
     */
    public VistaOferta() {
        // You can initialise any data required for the connected UI components here.
    }

    public VerticalLayout getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(VerticalLayout verticalLayout) {
		this.verticalLayout = verticalLayout;
	}

	/**
     * This model binds properties between VistaOferta and vista-oferta
     */
    public interface VistaOfertaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
