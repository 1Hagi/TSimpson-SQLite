package model;

public class Mensaje {

	public static void bienvenida(Usuario usuario) {
		System.out.println("\nBienvenido " + usuario.getNombre() + ":\n\t" + "Su tiempo disponible: "
				+ usuario.getTiempoDisponible() + " min.\n\tSu dinero disponible: " + usuario.getDineroDisponible()
				+ "0 $");
	}

	public static void sinCupos() {
		System.out.println("\nSe agotaron los cupos, Gracias por utilizar la App.");
	}

	public static void finPrograma() {
		System.out.println("\nEl programa ha finalizado, gracias por utilizar ésta App!");
	}

	public static void deseaComprar(Oferta unaOferta) {
		System.out.println("\nLe ofrecemos la siguiente oferta:\n\n" + unaOferta + "\n\nDesea comprar esta oferta? ");
	}

	public static void compraExitosa(Usuario usuario) {
		System.out.println("\nCompra realizada Exitosamente! \n------------------------------\n\t  Actualizacion\n\t"
				+ "Dinero disponible: $" + usuario.getDineroDisponible() + "0\n\tTiempo Disponible: "
				+ usuario.getTiempoDisponible() + " min.");
	}

	public static void NoPuedeComprarMas() {
		System.out.println("\nLas ofertas existentes exceden su dinero/tiempo disponible \nGracias por usar la App.");
	}

	public static void seguirComprando() {
		System.out.println("\nDesea seguir comprando? ");

	}

	public static void mostrarItinerario(Usuario usuario) {
		System.out.println(usuario.getItinerario());
	}

}
