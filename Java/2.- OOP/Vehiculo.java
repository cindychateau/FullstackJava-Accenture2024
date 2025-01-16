public class Vehiculo {

    /* Atributos del objeto */
    private int anio;
    private String marca;
    private String modelo;
    private String color;
    private int ruedas;

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

    public void encender() {
        //this = autoRojo
        System.out.println("El vehiculo "+this.color+" se encendio");
    }

    public void acelerar() {
        System.out.println("El vehiculo "+this.color+" aceleró. RUMMM RUMMM");
    }

    //Modificar = Setter
    public void setAnio(int anio) { //anio = 2001
        //this = auto1
        this.anio = anio; //auto1.anio = 2001;
    }

    //Obtener el valor = Getter
    public int getAnio() {
        //this = nuevoAuto
        return this.anio; //nuevoAuto.anio
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getRuedas() {
        return this.ruedas;
    }

}