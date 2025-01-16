public class AplicacionPublicaciones {
    public static void main(String[] args) {

        //Crear un usuario
        Usuario elena = new Usuario("Elena", 20, "elena@codingdojolatam.com");

        Usuario juana = new Usuario("Juana", 18, "juana@codingdojolatam.com");

        juana.agregarPublicacion("Viaje 2025", "Les comparto mis fotos del viaje que hice a Japón en el 2025");

        juana.agregarPublicacion("Nuevo Empleo", "¡Estoy contenta porque conseguí un nuevo empleo como desarrolladora!");

        juana.muestrePublicaciones();
    }
}