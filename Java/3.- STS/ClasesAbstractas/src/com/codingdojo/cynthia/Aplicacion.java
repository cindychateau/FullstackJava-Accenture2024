package com.codingdojo.cynthia;

import com.codingdojo.cynthia.clases.*;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado cuad1 = new Cuadrado(10);
		
		TrianguloEq tr1 = new TrianguloEq(10, 5);
		
		System.out.println("Area de Figura "+cuad1.nombre+":"+cuad1.area());
		
		System.out.println("Area Triangulo:"+tr1.area());
		
	}

}
