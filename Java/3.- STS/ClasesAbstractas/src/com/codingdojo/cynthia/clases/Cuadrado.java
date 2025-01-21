package com.codingdojo.cynthia.clases;

public class Cuadrado extends Figura {
	
	private double longitud;
	
	public static String nombre = "Cuadrado";
 
	public Cuadrado(double longitud) {
		super();
		this.longitud = longitud;
	}

	public double area() {
		return longitud*longitud;
	}
	
	
}
