package com.codingdojo.cynthia.clases;

public class TrianguloEq extends Figura {
	
	private double base;
	private double altura;
	
	public static String nombre = "Triangulo";
	
	public TrianguloEq(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	
	//public/protected/private tipodedato nombreMetodo(params, params)
	public double area() { 
		return (base*altura)/2;
	}
	
}
