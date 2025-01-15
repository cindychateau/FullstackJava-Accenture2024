public class Vehiculo {

    /* Atributos del objeto */
    public int anio;
    public String marca;
    public String modelo;
    public String color;
    public int ruedas;

    /* Método constructor: encargado de inicializar la instancia */
    public Vehiculo() {
        //Cree un nuevo vehículo vacío SIN INFO
    }
    
    /* Sobrecarga de método constructor */
    public Vehiculo(String color) { //color = "rojo"
        //this = autoRojo
        this.color = color; //autoRojo.color = "rojo"
    }

    public Vehiculo(int anio, String marca, String modelo, String color, int ruedas) {
        this.anio = anio;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ruedas = ruedas;
    }

}