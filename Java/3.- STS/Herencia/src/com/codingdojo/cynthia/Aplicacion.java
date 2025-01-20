package com.codingdojo.cynthia;

public class Aplicacion {

	public static void main(String[] args) {
		
		Vehiculo vehiculox = new Vehiculo("rojo");
		System.out.println("El color del auto es:"+vehiculox.getColor());
		
		Auto nuevoAuto = new Auto(2010, "Honda", "Civic", "Rojo", 4, 5);
		nuevoAuto.imprimeMarcaModelo();
		
		String textoDeRetorno = vehiculox.colorYRuedas();
		
		Bicicleta bici = new Bicicleta();
		
		
		nuevoAuto.acelerar();
		nuevoAuto.acelerar();
		nuevoAuto.acelerar();
		nuevoAuto.manejar();
		nuevoAuto.desacelerar();
		
		System.out.println("---------");
		
		bici.acelerar();
		bici.acelerar();
		bici.manejar();
		bici.desacelerar();
	}

}
