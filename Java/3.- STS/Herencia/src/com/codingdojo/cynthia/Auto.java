package com.codingdojo.cynthia;

//La clase Auto está heredando de la clase Vehiculo.
//Solo podemos tener una clase padre
public class Auto extends Vehiculo {
	
	//1.- TODOS los atributos del padre (Vehiculo) son heredados
	//2.- TODOS los métodos del padre (Vehiculo) sin heredados
	
	private int puertas;

	public Auto() { //Método constructor vacío
		super(); //Clase superior/padre
	}
	
	public Auto(int anio, String marca, String modelo, String color, int ruedas, int puertas) {
		super(anio, marca, modelo, color, ruedas); //Vehiculo(anio, marca, modelo, color, ruedas)
		/*
		 this.anio = anio;
		 this.marca = marca;
		 .....
		 */
		this.puertas = puertas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	@Override
	public void imprimeMarcaModelo() {
		//super = Vehiculo
		System.out.println(super.getMarca()+"-"+super.getModelo()+":"+this.color+","+this.puertas);
	}
	
	public String regresaMarcaModelo() {
		//super = Vehiculo
		return (super.getMarca()+"-"+super.getModelo()+":"+this.color);
	}

}
