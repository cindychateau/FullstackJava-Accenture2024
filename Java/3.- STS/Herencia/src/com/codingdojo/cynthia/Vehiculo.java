package com.codingdojo.cynthia;

public class Vehiculo {
	
	private int anio; //private: SOLO en esta clase me da permiso de acceder
	private String marca;
	private String modelo;
	protected String color;
	private int ruedas;
	
	protected int velocidad = 0;
	
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

	@Override //Sobreescribir
	public String toString() {
		return "Vehiculo (anio=" + anio + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", ruedas="
				+ ruedas + ") :) wuwuwu";
	}
	
	public void imprimeMarcaModelo() {
		//super = Vehiculo
		System.out.println(this.getMarca()+"-"+this.getModelo());
	}
	
	public String colorYRuedas() {
		return "Color:"+this.color+" #Ruedas:"+this.ruedas;
	}
	

}
