package model;

import java.util.ArrayList;

public class PromoPorcentual extends Promocion {

	private Integer descuento;

	public PromoPorcentual(String nombre, Integer id, OfertaTipo tipo, ArrayList<Oferta> excursiones, Integer descuento) {
		super(nombre, id, tipo, excursiones);
		this.descuento = descuento;
	}

	public Double getCosto() {
		Double costoTotal = 0.0;
		for (Oferta e : excursiones) {
			costoTotal += e.getCosto();
		}
		return costoTotal * descuento / 100;
	}

	@Override
	public String toString() {
		return "Promocion Porcentual: '" + this.nombre + "' incluye las excursiones:" + super.mostrarExcursiones()
				+ "\nPorcentaje de descuento: " + this.descuento + " %\n\tTiempo total necesario: " + this.getTiempo()
				+ " min.\n\tCosto en dinero total: $ " + this.getCosto();
	}
}
