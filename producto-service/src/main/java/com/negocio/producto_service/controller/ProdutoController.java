package com.negocio.producto_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.producto_service.model.Categoria;
import com.negocio.producto_service.model.Producto;
import com.negocio.producto_service.repository.ICategoriaRepository;
import com.negocio.producto_service.service.Interfaces.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProdutoController {
    @Autowired
    private IProductoService servProducto;

    @Autowired
    private ICategoriaRepository repoCategoria;

    @PostMapping("/crear")
    public String CreatePoducto(@RequestBody Producto producto) {

        if (producto.getNombre() == null || producto.getNombre().isEmpty() ||
                producto.getDescripcion() == null || producto.getDescripcion().isEmpty() ||
                producto.getCategoria() == null || producto.getCategoria().getNombre() == null ||
                producto.getCategoria().getNombre().isEmpty()) {
            return "Todos los campos son obligatorios";
        }

        Categoria categoria = repoCategoria.findByNombre(producto.getCategoria().getNombre());
        if (categoria == null) {
            return "La categoría no existe";
        }

        servProducto.createProducto(producto.getId_producto(), producto.getNombre(), producto.getCantidad(), producto.getDescripcion(),
                categoria.getId_categoria(), producto.getPrecio());
        return "Guardado";
    }

    @GetMapping("/traer/{id}")
    public Producto getProoductoById(@PathVariable Long id_producto) {

        return servProducto.getProductoById(id_producto);
    }

    @GetMapping("/traer")
    public List<Producto> getAllProductos() {

        List<Producto> listaProductos = servProducto.getAllProductos();

        return listaProductos;
    }

    @DeleteMapping("/eliminar/{id}")
    public String DeleteProducto(@PathVariable Long id_producto) {

        if (id_producto == null) {
            return "El producto con esta id no fue encontrado";
        } else {

            servProducto.deleteProduto(id_producto);

            return "Producto eliminado correctamente";
        }
    }

}
