package com.negocio.producto_service.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.producto_service.producto.dto.ProductoDTO;
import com.negocio.producto_service.producto.model.Categoria;
import com.negocio.producto_service.producto.model.Color;
import com.negocio.producto_service.producto.model.Producto;
import com.negocio.producto_service.producto.repositoy.ICategoriaRepository;
import com.negocio.producto_service.producto.repositoy.IColorRepository;
import com.negocio.producto_service.producto.repositoy.IProductoRepository;
import com.negocio.producto_service.producto.service.interfaces.IProductoService;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository repoProducto;
    @Autowired
    private ICategoriaRepository repoCategoria;

    @Autowired
    private IColorRepository repoColor;

    @Override
    public String
    createProducto(Long id_producto, String nombre, Integer cantidad, String descripcion,
            Long id_categoria, Double precio,Long id_color,Long id_talle) {
        Producto producto = new Producto();
        Categoria categoria = repoCategoria.findById(id_talle).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        Color color = repoColor.findById(id_talle).orElseThrow(() -> new RuntimeException("Color no encontrado"));
        producto.setId_producto(id_producto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        producto.setColor(color);
        repoProducto.save(producto);
        return "Producto guardado con exito";
    }

    @Override
    public String deleteProduto(Long id_producto) {
        if (id_producto.equals(null)) {
            return "El producto no existe";
        }
        repoProducto.deleteById(id_producto);

        return "Producto eliminado con exito";
    }

    @Override
    public List<Producto> getAllProductos() {
        try{

            List<Producto> listaProductos = repoProducto.findAll();
            return listaProductos;
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la lista de productos: " + e.getMessage());
        }
       
       
        
    }

    @Override
    public ProductoDTO getProductoById(Long id_producto) {
        Producto producto = repoProducto.findById(id_producto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId_producto(producto.getId_producto());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCategoria(producto.getCategoria().getNombre());
        productoDTO.setColor(producto.getColor().getNombre());
        productoDTO.setTalle(producto.getTalle().getNombre());
        productoDTO.setPrecio(producto.getPrecio());
     

        return productoDTO;
    }

    

}
