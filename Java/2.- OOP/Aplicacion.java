public class Aplicacion {
    public static void main(String[] args) {

        //Crear un nuevo vehiculo
        System.out.println("Creando auto1:");
        Vehiculo auto1 = new Vehiculo(); //cantidadVehiculos = 1
        //auto1.anio = 2001;
        auto1.setAnio(2001);
        //auto1.marca = "Honda";
        auto1.setMarca("Honda");
        //auto1.modelo = "Civic";
        auto1.setModelo("Civic");
        //auto1.color = "Blanco";
        auto1.setColor("Blanco");
        //auto1.ruedas = 4;
        auto1.setRuedas(4);

        System.out.println("Creando autoRojo:");
        Vehiculo autoRojo = new Vehiculo("rojo"); //cantidadVehiculos = 2

        System.out.println("Creando nuevoAuto:");
        Vehiculo nuevoAuto = new Vehiculo(2025, "BMW", "CX-3", "Azul", 4); //cantidadVehiculos = 3

        System.out.println("Auto1 marca:"+auto1.getMarca());
        System.out.println("autoRojo color:"+autoRojo.getColor());
        System.out.println("nuevoAuto anio:"+nuevoAuto.getAnio());

        autoRojo.encender();
        autoRojo.acelerar();

        System.out.println(autoRojo.getColor());

        Vehiculo.esAutomotora();

        //cambio de prueba
    }
}