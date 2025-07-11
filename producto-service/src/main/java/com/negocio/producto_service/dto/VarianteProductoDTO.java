package com.negocio.producto_service.dto;

import com.negocio.producto_service.model.Color;
import com.negocio.producto_service.model.Producto;
import com.negocio.producto_service.model.Talle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VarianteProductoDTO {

    private Long id_variante;

    private Producto producto;

    private Talle talle;

    private Color color;

    private Integer stock;

    private Double precio;
}
