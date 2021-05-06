package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import interfaz.Empleado;

public class Lista_empleados extends VerticalLayout{
	public Vista_gestion_empleados _vista_gestion_empleados;
	public Vector<Empleado> _list_Empleado = new Vector<Empleado>();
	
	
	public Lista_empleados() {
		super();
	}
	
	
}