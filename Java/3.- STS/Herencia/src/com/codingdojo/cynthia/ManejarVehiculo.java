package com.codingdojo.cynthia;

public interface ManejarVehiculo {
	
	/*Método default: NO necesita ser implementado, sino que directamente el comportamiento
	 * se "hereda" hacia la clase que implementa la interfaz*/
	public default void manejar() {
		System.out.println("Se esta manejando el vehiculo");
	}
	
	/*Método abstracto: es aquel que OBLIGAMOS a nuestra clase a implementar*/
	abstract void acelerar();
	abstract void desacelerar();
	
	/*Método estático: Es aquel que pertenece a la interfaz. "Ayudantes"*/

}