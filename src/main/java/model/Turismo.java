package model;

import java.io.IOException;
import java.util.*;

public class Turismo {

	public static List<Usuario> usuarios = new ArrayList<Usuario>();
	public static List<Excursion> excursiones = new ArrayList<Excursion>();
	public static List<Promocion> promociones = new ArrayList<Promocion>();
	public static List<Oferta> ofertas = new ArrayList<Oferta>();

	public static void iniciarApp() throws IOException{
		
		for (Usuario usuario : Turismo.usuarios) {
			boolean seguirOfreciendo = true;
			Oferta unaOferta;
			Mensaje.bienvenida(usuario);
			if (Transaccion.comprobarCupoTotal(ofertas)) {
				Collections.sort(Turismo.ofertas, new Ordenamiento(usuario.getFavorito()));
				while (seguirOfreciendo) {
					if (Transaccion.hayOfertasDisponibles(Turismo.ofertas, usuario)) {
						unaOferta = Transaccion.getOferta();
						Mensaje.deseaComprar(unaOferta);
						if (usuario.responderPregunta()) {
							Transaccion.comprarOferta(usuario, unaOferta);
							Mensaje.compraExitosa(usuario);
							Mensaje.seguirComprando();
							seguirOfreciendo = usuario.responderPregunta();
						} else {
							Transaccion.denegarOferta(usuario, unaOferta);
							Mensaje.seguirComprando();
							seguirOfreciendo = usuario.responderPregunta();
						}
					} else {
						Mensaje.NoPuedeComprarMas();
						seguirOfreciendo = false;
					}
				}
			} else {
				Mensaje.sinCupos();
			}
			Mensaje.mostrarItinerario(usuario);
		}
		Mensaje.finPrograma();
	}

}
