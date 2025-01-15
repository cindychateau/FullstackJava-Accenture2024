public class Aplicacion {
    public static void main(String[] args) {

        //Crear un nuevo vehiculo
        Vehiculo auto1 = new Vehiculo();
        auto1.anio = 2001;
        auto1.marca = "Honda";
        auto1.modelo = "Civic";
        auto1.color = "Blanco";
        auto1.ruedas = 4;

        Vehiculo autoRojo = new Vehiculo("rojo");

        Vehiculo nuevoAuto = new Vehiculo(2025, "BMW", "CX-3", "Azul", 4);

        System.out.println("Auto1 marca:"+auto1.marca);
        System.out.println("autoRojo color:"+autoRojo.color);
        System.out.println("nuevoAuto anio:"+nuevoAuto.anio);

    }
}