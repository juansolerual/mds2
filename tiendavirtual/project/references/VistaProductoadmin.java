package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-productoadmin template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productoadmin")
@JsModule("./src/vista-productoadmin.js")
public class VistaProductoadmin extends PolymerTemplate<VistaProductoadmin.VistaProductoadminModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaProductoadmin.
     */
    public VistaProductoadmin() {
        // You can initialise any data required for the connected UI components here.
    }

    public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	/**
     * This model binds properties between VistaProductoadmin and vista-productoadmin
     */
    public interface VistaProductoadminModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
