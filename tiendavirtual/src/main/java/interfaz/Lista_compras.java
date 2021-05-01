package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Pendiente;
import interfaz.Ver_detalle;

public class Lista_compras extends HorizontalLayout{
	private event _marcar_como_enviado;
	public Vista_listado_de_compras _vista_listado_de_compras;
	public Vector<Ver_detalle> _list_Ver_detalle = new Vector<Ver_detalle>();
	public VerticalLayout v1 = new VerticalLayout();
	public VerticalLayout v2 = new VerticalLayout();
	public VerticalLayout v3 = new VerticalLayout();
	public VerticalLayout v4 = new VerticalLayout();
	public Label pedido = new Label();
	public Label totalPedido = new Label();
	public Label cliente = new Label();
	public Label estadoPedido = new Label();
	public Label direccion = new Label();
	public Button verDetalle = new Button("Ver detalle");
	public Button marcarComoEnviado = new Button("Marcar como enviado");

	public void Marcar_como_enviado() {
		throw new UnsupportedOperationException();
	}

	

	public Lista_compras() {
		// TODO Auto-generated constructor stub
		
		v1.add(pedido, cliente, direccion);
		v2.add(totalPedido, estadoPedido);
		v3.add(verDetalle);
		v4.add(marcarComoEnviado);
		add(v1, v2, v3, v4);
	}
}