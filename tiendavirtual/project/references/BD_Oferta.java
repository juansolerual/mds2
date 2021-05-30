package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Oferta;

public class BD_Oferta {
	public BDPrincipal _bDPrincipal;
	public Vector<Oferta> _contiene_ofertas = new Vector<Oferta>();

	public List<Oferta> cargarOfertas() throws PersistentException {
		List<Oferta> ofertas = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {	
			ofertas = OfertaDAO.queryOferta(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return ofertas;
	}

	public Oferta cargarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public int guardarOferta(Oferta aOferta) throws PersistentException {
		int id_oferta = -1;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {

			
			Oferta ofer = OfertaDAO.createOferta();
			ofer.setNombreOferta(aOferta.getNombreOferta());
			ofer.setActivada(aOferta.getActivada());
			ofer.setFechaCaducidadOferta(aOferta.getFechaCaducidadOferta());
			ofer.setPorcentajeOferta(aOferta.getPorcentajeOferta());
			ofer.setPrecioOferta(aOferta.getPrecioOferta());
			ofer.setUrlImagen(aOferta.getUrlImagen());
			
			
			OfertaDAO.save(ofer);
			id_oferta = ofer.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return id_oferta;
	}
}