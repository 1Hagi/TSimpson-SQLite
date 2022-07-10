package model;

import java.util.*;

public class Itinerario {

	private ArrayList<Oferta> ofertasCompradas;
	private ArrayList<Oferta> ofertasIgnoradas;

	public Itinerario() {
		this.ofertasCompradas = new ArrayList<Oferta>();
		this.ofertasIgnoradas = new ArrayList<Oferta>();
	}

	public ArrayList<Oferta> getOfertasCompradas() {
		return ofertasCompradas;
	}

	public void addOfertasCompradas(Oferta oferta) {
		this.ofertasCompradas.add(oferta);
	}

	public ArrayList<Oferta> getOfertasIgnoradas() {
		return ofertasIgnoradas;
	}

	public void addOfertasIgnoradas(Oferta oferta) {
		this.ofertasIgnoradas.add(oferta);
	}

	public String mostrarOfertas() {
		String lista = "";
		for (Oferta oferta : this.ofertasCompradas) {
			lista += oferta + "\n\n";
		}
		return lista;
	}

	@Override
	public String toString() {
		return "Itinerario del usuario:\n\n" + mostrarOfertas();
	}
}
