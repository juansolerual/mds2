package tiendavirtual;

import javax.servlet.http.Cookie;

import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.Transportista;
import basededatos.iAdmin;
import interfaz.Admin;
import interfaz.Usuario_registrado;

public class cookiesHelper {
	
	public static Administrador administrador = null;
	public static Encargado_compras encargado_compras = null;
	public static Transportista transportista = null;
	public static String usuario = null;
	public static int idUsuario = -1;
	public static Cliente cliente = null;
	public iAdmin adm;
	public VaadinSession session;
	
	public static class getCarrito{
		
	}
	
	public static Cliente getCliente(){
		if (cliente != null) {
			return cliente;
		}else return null;	
	}
	
	public static Administrador getAdministrador(){
		if (administrador != null) {
			return administrador;
		}else return null;	
	}
	
	public static Encargado_compras getEncargadoCompras() {
		if (encargado_compras != null) {
			return encargado_compras;
		}else return null;	
	}
	
	public static Transportista getTransportista() {
		if (transportista != null) {
			return transportista;
		}else return null;	
	}
	
	public static boolean isEncargadoCompras() {
		if (encargado_compras!= null) {
			return true;
		}else return false;
	}
	public static boolean isAdministrador() {
		if (administrador!= null) {
			return true;
		}else return false;
	}
	
	public static boolean isCliente() {
		if (cliente!= null) {
			return true;
		}else return false;
	}
	
	public static boolean istransportista() {
		if (transportista!= null) {
			return true;
		}else return false;
	}
	
	public static boolean isNoRegistrado() {
		if (cliente == null && administrador == null) {
			return true;
		}else return false;
	}
	
	public cookiesHelper() {
		super();
	    adm = new BDPrincipal();
	    cliente = null;
	    encargado_compras = null;
	    administrador = null;
	    transportista = null;
    	session = VaadinSession.getCurrent();


		Cookie[] readCookie = VaadinRequest.getCurrent().getCookies();
		
		if (readCookie == null) return;
		
		for (Cookie cookie : readCookie) {
			System.out.println("name" + cookie.getName());
			System.out.println("value" + cookie.getValue());
			if (cookie.getName().equals("tipoUsuario")) {
				usuario = cookie.getValue();
			}
			if (cookie.getName().equals("cliente")){
				idUsuario =  Integer.parseInt(cookie.getValue());
			}
			
		}
		
		
		 if (usuario != null) {
	        	if (usuario.equals("cliente")) {
	        		if (idUsuario != 0) {
	            		cliente = adm.cargarCliente(idUsuario);
	    				session.setAttribute("cliente", cliente);
	            	}
	            	
	            }else if (usuario.equals("admin")) {
	            	if (idUsuario != 0) {
	            		administrador = adm.cargarAdministrador(idUsuario);
	    				session.setAttribute("admin", administrador);
	            	}
	            	
	            }else if (usuario.equals("encargado")) {
	            	if (idUsuario != 0) {
	            		encargado_compras = adm.cargarEncargadoCompras(idUsuario);
	    				session.setAttribute("encargado", encargado_compras);
	            	}
	            	
	            }else if (usuario.equals("transportista")) {
	            	if (idUsuario != 0) {
	            		transportista = adm.cargarTransportista(idUsuario);
	    				session.setAttribute("transportista", transportista);
	            	}
	            	
	            }
		 }
		 
		
		
	}
	
	
	
	
	
}
