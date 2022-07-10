package model;

public abstract class Oferta implements Comparable<Oferta> {

	protected String nombre;
	protected Integer id;
	protected OfertaTipo tipo;

	public Oferta(String nombre, Integer id, OfertaTipo tipo) {
		this.nombre = nombre;
		this.id = id;
		this.tipo = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public OfertaTipo getTipo() {
		return this.tipo;
	}

	@Override
	public int compareTo(Oferta otraOferta) {
		if (this instanceof Promocion && otraOferta instanceof Excursion) {
			return -1;
		} else if (this instanceof Excursion && otraOferta instanceof Promocion) {
			return 1;
		} else if (this.getCosto() > otraOferta.getCosto()) {
			return -1;
		} else if (this.getCosto() < otraOferta.getCosto()) {
			return 1;
		} else if (this.getTiempo() > otraOferta.getTiempo()) {
			return -1;
		} else if (this.getTiempo() < otraOferta.getTiempo()) {
			return 1;
		}
		return 0;
	}

	public abstract Integer getTiempo();

	public abstract Double getCosto();

	public abstract Integer getCupo();

	public abstract void venderCupo();

}