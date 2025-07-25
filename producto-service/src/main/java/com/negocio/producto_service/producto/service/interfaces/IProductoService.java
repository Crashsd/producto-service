package com.negocio.producto_service.producto.service.interfaces;

import java.util.List;

import com.negocio.producto_service.producto.dto.ProductoDTO;
import com.negocio.producto_service.producto.model.Producto;

public interface IProductoService {

    public String createProducto(Long id_producto, String nombre,Integer cantidad ,
    String descripcion, Long id_categoria,Double precio, Long id_color,Long id_talle
    );

    public String deleteProduto(Long id);

    public List <Producto> getAllProductos();

    public ProductoDTO getProductoById(Long id);

    
}
