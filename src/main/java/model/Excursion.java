package model;

import java.text.DecimalFormat;

public class Excursion extends Oferta {

	private Integer tiempo;
	private Double costo;
	private Integer cupo;

	public Excursion(String nombre, Integer id, OfertaTipo tipo, Integer tiempo, Double dinero, Integer cupo) {
		super(nombre, id, tipo);
		this.tiempo = tiempo;
		this.costo = dinero;
		this.cupo = cupo;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public Double getCosto() {
		return costo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void venderCupo() {
		this.cupo--;
	}

	@Override
	public String toString() {
		DecimalFormat frmt = new DecimalFormat("#.00");
		return "  Excursion: " + super.nombre + "  --> tipo: <" + this.tipo + ">, costo: <$ " + frmt.format(this.costo)
				+ ">, tiempo: <" + this.tiempo + " min.>\n";
	}

	public Integer getId() {
		return this.id;
	}
}
