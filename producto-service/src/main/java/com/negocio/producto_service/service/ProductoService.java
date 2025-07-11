package com.negocio.producto_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.producto_service.model.Categoria;
import com.negocio.producto_service.model.Producto;
import com.negocio.producto_service.repository.ICategoriaRepository;
import com.negocio.producto_service.repository.IProductoRepository;
import com.negocio.producto_service.service.Interfaces.IProductoService;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository repoProducto;
    @Autowired
    private ICategoriaRepository repoCategoria;

    @Override
    public String createProducto(Long id_producto, String nombre, String descripcion, Long id_categoria) {
        Categoria categoria = repoCategoria.findById(id_categoria).orElse(null);
        Producto producto = new Producto();
        producto.setId_producto(id_producto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria);
        repoProducto.save(producto);
        return "Producto guardado con exito";
    }

    @Override
    public String deleteProduto(Long id) {
        repoProducto.deleteById(id);

        return "Producto eliminado con exito";
    }

    @Override
    public List<Producto> getAllProductos() {

        List<Producto> listaProductos = repoProducto.findAll();
        if (listaProductos.isEmpty()) {
            return null;

        } else {
            return listaProductos;
        }
    }

    @Override
    public Producto getProductoById(Long id) {
        Producto producto = repoProducto.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return producto;
    }

}
