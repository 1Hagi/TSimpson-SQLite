package model;

import java.util.ArrayList;
import java.util.List;

public class Transaccion {

	public static ArrayList<Oferta> ofertasDisponibles = new ArrayList<Oferta>();

	public static boolean comprobarCupoTotal(List<Oferta> ofertas) {
		Transaccion.ofertasDisponibles.clear();
		for (Oferta oferta : ofertas) {
			if (oferta.getCupo() > 0) {
				Transaccion.ofertasDisponibles.add(oferta);
			}
		}
		return !Transaccion.ofertasDisponibles.isEmpty();
	}

	public static boolean hayOfertasDisponibles(List<Oferta> ofertas, Usuario usuario) {

		for (Oferta oferta : ofertas) {
			if (oferta.getCosto() > usuario.getDineroDisponible()
					|| oferta.getTiempo() > usuario.getTiempoDisponible()) {
				Transaccion.ofertasDisponibles.remove(oferta);
			}

			for (Oferta ofertaComprada : usuario.getOfertasCompradas()) {
				if (ofertaComprada.getNombre().equals(oferta.getNombre())) {
					if (ofertaComprada instanceof Promocion) {
						for (Oferta ofertaCompradaenPromo : ((Promocion) oferta).getExcursiones()) {
							Transaccion.ofertasDisponibles.remove(ofertaCompradaenPromo);
						}
						Transaccion.ofertasDisponibles.remove(oferta);
					} else {
						Transaccion.ofertasDisponibles.remove(oferta);
					}
				}
			}

			for (Oferta ofertaIgnorada : usuario.getOfertasIgnoradas()) {
				if (ofertaIgnorada.getNombre().equals(oferta.getNombre())) {
					Transaccion.ofertasDisponibles.remove(oferta);
				}
			}
		}

		return !ofertasDisponibles.isEmpty();
	}

	public static Oferta getOferta() {
		return Transaccion.ofertasDisponibles.get(0);
	}

	public static void comprarOferta(Usuario usuario, Oferta unaOferta) {
		usuario.comprar(unaOferta);
		unaOferta.venderCupo();
	}

	public static void denegarOferta(Usuario usuario, Oferta unaOferta) {
		usuario.denegar(unaOferta);
	}

}
