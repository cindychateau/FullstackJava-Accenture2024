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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="hobbies")
public class Hobby {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // AI
	private Long id;
	
	@NotNull
	private String pasatiempo;
	
	@Column(updatable=false) // Este atributo no es puede actualizar
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Hobby() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(String pasatiempo) {
		this.pasatiempo = pasatiempo;
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
