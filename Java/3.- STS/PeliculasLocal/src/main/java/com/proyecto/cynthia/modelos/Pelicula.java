package com.proyecto.cynthia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	private Long id;
	
	@NotBlank(message="Título obligatorio")
	@Size(min=2, message="Título debe tener al menos 2 caracteres")
	private String titulo;
	
	@NotNull(message="Año obligatorio") //Cuando el tipo de dato es diferente a String, SOLO utilizamos NotNull
	@Min(value=1900, message="El año mínimo en 1900")
	@Max(2026)
	private Integer anio;
	
	@NotBlank(message="Director obligatorio")
	private String director;
	
	@NotBlank(message="URL obligatorio")
	private String urlImagen;
	
	@NotBlank(message="Sinopsis obligatorio")
	@Column(columnDefinition="TEXT") //El tipo de dato de la columna es TEXT (65k caracteres)
	private String sinopsis;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id") //Llave foránea
	private Usuario creador; //Usuario que creó la peli
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="pelis_favoritas",
			joinColumns= @JoinColumn(name="pelicula_id"),
			inverseJoinColumns= @JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuarios; //Los usuarios que dieron fav
	
	public Pelicula() {} //Constructor Vacío

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@PrePersist //Antes de crear el registro
	protected void onCreate() {
		this.createdAt = new Date(); //Genera una nueva fecha para createdAt (DEFAULT CURRENT_TIMESTAMP)
	}
	
	@PreUpdate //Antes de actualizar el registro
	protected void onUpdate() {
		this.updatedAt = new Date(); //Genera una nueva fecha para updatedAt (DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
	}
	
}
