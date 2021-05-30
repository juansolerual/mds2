package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-productolista template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productolista")
@JsModule("./src/vista-productolista.js")
public class VistaProductolista extends PolymerTemplate<VistaProductolista.VistaProductolistaModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	/**
     * Creates a new VistaProductolista.
     */
    public VistaProductolista() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductolista and vista-productolista
     */
    public interface VistaProductolistaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
