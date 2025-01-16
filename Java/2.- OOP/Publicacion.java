import java.util.Date;
public class Publicacion {

    private String titulo;
    private String contenido;
    private Date fecha;

    public Publicacion() {
        //Constructor vacío
        this.fecha = new Date();
    }

    public Publicacion(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = new Date();
    }


    //Getters y Setters
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}