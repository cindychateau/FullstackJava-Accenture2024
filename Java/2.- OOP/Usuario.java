import java.util.ArrayList;
public class Usuario {

    private String nombre;
    private int edad;
    private String email;

    //Lista de Publicaciones
    private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

    public Usuario() {
        //Constructor vacío
    }

    //Constructor con todos los datos
    public Usuario(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    //Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*Un usuario específico cree una publicación.
    Crear un nuevo objeto publicación
    Agregar esa publicación a mi lista de publicaciones
    */
    public void agregarPublicacion(String tituloPublicacion, String contenidoPublicacion) {
        //tituloPublicacion = "Viaje 2025"
        //contenidoPublicacion = "Les comparto mis fotos del viaje que hice a Japón en el 2025";

        //Crea la nueva publicación
        Publicacion nuevaPublicacion = new Publicacion(tituloPublicacion, contenidoPublicacion);

        System.out.println("Generando publicación "+nuevaPublicacion.getFecha()+":"+tituloPublicacion+" creada por "+this.nombre);

        //Me agrega la publicación a la lista del usuario
        this.publicaciones.add(nuevaPublicacion);
        
    }

    public void muestrePublicaciones() {
        System.out.println("Mostrando publicaciones de:"+this.nombre);
        /*
        juana.publicaciones = LISTA(
        0 => Publicacion(Viaje 2025, texto pub)
        1 => Publicacion(Nuevo Empleo, contenido nuevo empl)
        )
        
         */
        /*
        for(int i=0; i < publicaciones.length; i++) {
            p = array[i];
        }
         */
        for(Publicacion p : this.publicaciones) {
            //p = OBJETO de Publicación
            System.out.println("Titulo:"+p.getTitulo());
            System.out.println("Contenido:"+p.getContenido());
            System.out.println("Fecha:"+p.getFecha());
            System.out.println("---------------");
        }

    }
}