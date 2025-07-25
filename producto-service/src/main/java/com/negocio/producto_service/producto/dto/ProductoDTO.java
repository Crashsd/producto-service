package com.negocio.producto_service.producto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {


    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String color;
    private String talle;
    private Double precio;
}
