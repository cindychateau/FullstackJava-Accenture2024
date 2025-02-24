package com.proyecto.prueba.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //Constructor  vacío
@AllArgsConstructor //Constructor con todos los atributos
public class Producto {
    
    private Long id;
    private String nombre;
    private String descripcion;
    
}
