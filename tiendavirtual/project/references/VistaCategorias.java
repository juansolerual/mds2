package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-categorias template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-categorias")
@JsModule("./src/vista-categorias.js")
public class VistaCategorias extends PolymerTemplate<VistaCategorias.VistaCategoriasModel> {

    @Id("horizontalLayout")
	private HorizontalLayout horizontalLayout;

	/**
     * Creates a new VistaCategorias.
     */
    public VistaCategorias() {
        // You can initialise any data required for the connected UI components here.
    }

    public HorizontalLayout getHorizontalLayout() {
		return horizontalLayout;
	}

	public void setHorizontalLayout(HorizontalLayout horizontalLayout) {
		this.horizontalLayout = horizontalLayout;
	}

	/**
     * This model binds properties between VistaCategorias and vista-categorias
     */
    public interface VistaCategoriasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
