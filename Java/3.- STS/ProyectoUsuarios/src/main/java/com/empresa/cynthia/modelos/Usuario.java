package com.empresa.cynthia.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios") //(name="users")
public class Usuario {
	
	@Id //Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AI: Autoincremento
	private Long id;
	
	//@Column(name="name")
	@NotNull //@NotEmpty
	@Size(min=2, max=100, message="El nombre debe tener al menos 2 caracteres")
	private String nombre;
	
	@NotNull
	@Size(min=2, max=100)
	private String apellido;
	
	@NotNull
	@Size(min=2, max=200)
	@Email
	private String email;
	
	@Column(updatable=false) //Que la columna no puede editarse
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	@PrePersist //ANTES de crear al usuario
	protected void onCreate() {
		this.createdAt = new Date(); // DEFAULT CURRENT_TIMESTAMP
	}
	
	@PreUpdate //ANTES de que yo actualice
	protected void onUpdate() {
		this.updatedAt = new Date(); // DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT TIME_STAMP
	}

}
