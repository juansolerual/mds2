package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Empleado extends HorizontalLayout{
	private event _eliminar_empleado;
	public Lista_empleados _lista_empleados;
	public Modificar_datos_empleado _modificar_datos_empleado;
	


	public VerticalLayout v1 = new VerticalLayout();
	public VerticalLayout v2 = new VerticalLayout();
	public VerticalLayout v3 = new VerticalLayout();
	public VerticalLayout v4 = new VerticalLayout();
	public Image img = new Image();
	public Label empleado = new Label();
	public Label empleo = new Label();
	public Label datosEmpleado = new Label();
	public Button modificarDatos = new Button("Modificar Datos");
	public Button eliminarEmpleado = new Button("Eliminar empleado");
	
	public Empleado() {
		super();
		img.setWidth("100px");
		img.setHeight("100px");
		img.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		v1.add(img);
		v2.add(empleo, empleado);
		v3.add(datosEmpleado);
		v4.add(modificarDatos, eliminarEmpleado);
		add(v1, v2, v3, v4);
		
		setWidth("100%");
		getStyle().set("border","1px solid blue");
		v2.getStyle().set("border","1px solid blue").set("margin", "20px");
		v3.getStyle().set("border","1px solid blue").set("margin", "20px");
		v4.getStyle().set("margin", "20px");
		

		
		
	}

	public void Eliminar_empleado() {
		
	}
}