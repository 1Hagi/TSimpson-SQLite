package model;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private Integer tiempoDisponible;
	private Double dineroDisponible;
	private OfertaTipo tipoFavorito;
	private Itinerario itinerario;

	public Usuario(String nombre, OfertaTipo tipoFavorito, Integer tiempoDisponible, Double dineroDisponible) {
		this.nombre = nombre;
		this.tiempoDisponible = tiempoDisponible;
		this.dineroDisponible = dineroDisponible;
		this.tipoFavorito = tipoFavorito;
		this.itinerario = new Itinerario();
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getTiempoDisponible() {
		return tiempoDisponible;
	}

	public Double getDineroDisponible() {
		return dineroDisponible;
	}

	public OfertaTipo getFavorito() {
		return this.tipoFavorito;
	}

	public String getItinerario() {
		return this.itinerario.toString();
	}

	public ArrayList<Oferta> getOfertasCompradas() {
		return this.itinerario.getOfertasCompradas();
	}

	public ArrayList<Oferta> getOfertasIgnoradas() {
		return this.itinerario.getOfertasIgnoradas();
	}

	public void comprar(Oferta unaOferta) {
		this.dineroDisponible -= unaOferta.getCosto();
		this.tiempoDisponible -= unaOferta.getTiempo();
		this.itinerario.addOfertasCompradas(unaOferta);
	}

	public void denegar(Oferta unaOferta) {
		this.itinerario.addOfertasIgnoradas(unaOferta);
	}

	public boolean responderPregunta() throws IOException {

		String respuesta = null;
		boolean r = false;

		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);

		respuesta = br.readLine();
		respuesta = respuesta.toLowerCase();

		int intentos = 3;
		int ans = -1;

		while (intentos >= 1 && ans == -1) {
			if (respuesta.equals("si") || respuesta.equals("s")) {
				ans = 1;
				r = true;
			} else if (respuesta.equals("no") || respuesta.equals("n")) {
				ans = 0;
				r = false;
			} else if (intentos > 1) {
				System.out.println(
						".. la respuesta ingresada es incorrecta, debe contestar con 'Si' o 'No' (intentos restantes "
								+ (intentos - 1) + ")");
				respuesta = br.readLine();
				respuesta = respuesta.toLowerCase();
			} else {
				System.out.println(".. intentos agotados, la oferta se rechazara automaticamente .. ");
				ans = 0;
				r = false;
			}
			intentos--;
		}
		return r;
	}

	@Override
	public String toString() {
		DecimalFormat frmt = new DecimalFormat("#.00");
		return "Cliente [nombre=" + nombre + ", tiempoDisponible=" + tiempoDisponible + ", dineroDisponible="
				+ frmt.format(dineroDisponible) + ", tipoFavorito=" + tipoFavorito + "]";
	}

}
