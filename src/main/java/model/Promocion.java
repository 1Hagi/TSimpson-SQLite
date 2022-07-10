package model;

import java.util.*;

public abstract class Promocion extends Oferta {

	ArrayList<Oferta> excursiones;

	public Promocion(String nombre, Integer id, OfertaTipo tipo, ArrayList<Oferta> excursiones) {
		super(nombre, id, tipo);
		this.excursiones = new ArrayList<Oferta>();
		for (Oferta o : excursiones) {
			this.excursiones.add(o);
		}
	}

	public Integer getTiempo() {
		Integer tiempoTotal = 0;
		for (Oferta e : excursiones) {
			tiempoTotal += e.getTiempo();
		}
		return tiempoTotal;
	}

	public Integer getCupo() {
		Integer cupoTotal = 99;
		for (Oferta e : excursiones) {
			if (cupoTotal > e.getCupo()) {
				cupoTotal = e.getCupo();
			}
		}
		return cupoTotal;
	}

	public void venderCupo() {
		for (Oferta e : this.excursiones) {
			e.venderCupo();
		}
	}

	public ArrayList<Oferta> getExcursiones() {
		return this.excursiones;
	}

	public String mostrarExcursiones() {
		String excursiones = "";
		for (Oferta e : this.excursiones) {
			excursiones += "\n" + e.toString();
		}
		return excursiones;
	}
}