package com.negocio.producto_service.service.Interfaces;

import java.util.List;

import com.negocio.producto_service.model.Producto;

public interface IProductoService {

    public String createProducto(Long id_producto, String nombre, String descripcion, Long id_categoria);

    public String deleteProduto(Long id);

    public List <Producto> getAllProductos();

    public Producto getProductoById(Long id);
}
