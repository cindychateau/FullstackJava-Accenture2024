package com.codingdojo.cynthia;

public class Vehiculo {
	
	private int anio;
	private String marca;
	private String modelo;
	private String color;
	private int ruedas;
	
	public Vehiculo() {
	}

	public Vehiculo(String color) {
		this.color = color;
	}

	public Vehiculo(int anio, String marca, String modelo, String color, int ruedas) {
		this.anio = anio;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.ruedas = ruedas;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}	

}
