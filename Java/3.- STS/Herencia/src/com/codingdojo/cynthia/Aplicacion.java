package com.codingdojo.cynthia;

public class Aplicacion {

	public static void main(String[] args) {
		
		Vehiculo vehiculox = new Vehiculo("rojo");
		System.out.println("El color del auto es:"+vehiculox.getColor());
		
		Auto nuevoAuto = new Auto(2010, "Honda", "Civic", "Rojo", 4, 5);
		nuevoAuto.imprimeMarcaModelo();
		
	}

}
