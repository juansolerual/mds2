package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;

/**
 * A Designer generated component for the vista-producto_usuario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productousuario")
@JsModule("./src/vista-productousuario.js")
public class VistaProductousuario extends PolymerTemplate<VistaProductousuario.VistaProductousuarioModel> {

   

	

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaProducto_usuario.
     */
    public VistaProductousuario() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProducto_usuario and vista-producto_usuario
     */
    public interface VistaProductousuarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
