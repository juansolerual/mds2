package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-visualizarpantalla template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-visualizarpantalla")
@JsModule("./src/vista-visualizarpantalla.js")
public class VistaVisualizarpantalla extends PolymerTemplate<VistaVisualizarpantalla.VistaVisualizarpantallaModel> {

   
	@Id("verticualLayout")
	private VerticalLayout verticualLayout;
	@Id("horizontalSplit")
	private Element horizontalSplit;

	/**
     * Creates a new VistaVisualizarpantalla.
     */
    public VistaVisualizarpantalla() {
        // You can initialise any data required for the connected UI components here.
    }

    

	public Element getHorizontalSplit() {
		return horizontalSplit;
	}



	public void setHorizontalSplit(Element horizontalSplit) {
		this.horizontalSplit = horizontalSplit;
	}



	public VerticalLayout getVerticualLayout() {
		return verticualLayout;
	}

	public void setVerticualLayout(VerticalLayout verticualLayout) {
		this.verticualLayout = verticualLayout;
	}

	/**
     * This model binds properties between VistaVisualizarpantalla and vista-visualizarpantalla
     */
    public interface VistaVisualizarpantallaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
