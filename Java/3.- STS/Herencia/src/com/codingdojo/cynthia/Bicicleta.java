package com.codingdojo.cynthia;

public class Bicicleta extends Vehiculo implements ManejarVehiculo/*, LavarVehiculo*/ {
	
	public static int limiteVelocidad = 20;
	
	public void acelerar() {
		//Condicional que revise el limite de velocidad
		System.out.println("Pedaleo mas rapido");
		velocidad++;
		System.out.println("Mi velocidad es de:"+velocidad+" km/h.");
	}
	
	public void desacelerar() {
		System.out.println("Bajo despacito los pies para bajar la velocidad");
		velocidad--;
		System.out.println("Mi velocidad es de:"+velocidad+" km/h.");
	}
	
}
