package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-productosusuario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productosusuario")
@JsModule("./src/vista-productosusuario.js")
public class VistaProductosusuario extends PolymerTemplate<VistaProductosusuario.VistaProductosusuarioModel> {

    @Id("horizontalProductos")
	private HorizontalLayout horizontalProductos;
    
    
    
	public HorizontalLayout getHorizontalProductos() {
		return horizontalProductos;
	}

	public void setHorizontalProductos(HorizontalLayout horizontalProductos) {
		this.horizontalProductos = horizontalProductos;
	}

	/**
     * Creates a new VistaProductosusuario.
     */
    public VistaProductosusuario() {
        // You can initialise any data required for the connected UI components here.
    	
    	

    }

    /**
     * This model binds properties between VistaProductosusuario and vista-productosusuario
     */
    public interface VistaProductosusuarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    
}
