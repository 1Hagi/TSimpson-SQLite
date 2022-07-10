package model;

import java.util.Comparator;

public class Ordenamiento implements Comparator<Oferta> {

	private OfertaTipo preferencia;

	public Ordenamiento(OfertaTipo preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Oferta unaOferta, Oferta otraOferta) {
		if (unaOferta.getTipo() == this.preferencia && otraOferta.getTipo() != this.preferencia) {
			return -1;
		} else if (unaOferta.getTipo() != this.preferencia && otraOferta.getTipo() == this.preferencia) {
			return 1;
		}
		return unaOferta.compareTo(otraOferta);
	}

}
