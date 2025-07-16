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

import com.negocio.producto_service.Exceptions.ProductNotFoundException;
import com.negocio.producto_service.dto.ProductoDTO;
import com.negocio.producto_service.model.Categoria;
import com.negocio.producto_service.model.Color;
import com.negocio.producto_service.model.Producto;
import com.negocio.producto_service.model.Talle;
import com.negocio.producto_service.repository.ICategoriaRepository;
import com.negocio.producto_service.repository.IColorRepository;
import com.negocio.producto_service.repository.ITalleRepository;
import com.negocio.producto_service.service.Interfaces.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService servProducto;

    @Autowired
    private ICategoriaRepository repoCategoria;

    @Autowired
    private IColorRepository repoColor;

     @Autowired
    private ITalleRepository repoTalle;

    @PostMapping("/crear")
    public String CreatePoducto(@RequestBody Producto producto) {
        Categoria categoria = repoCategoria.findById(producto.getCategoria().getId_categoria())
        .orElseThrow(()->new ProductNotFoundException("La categoria no fue encontrada"));

        Color color =repoColor.findById(producto.getColor().getId_color())
        .orElseThrow(()->new ProductNotFoundException("El color no fue encontrado"));

        Talle talle =repoTalle.findById(producto.getTalle().getId_talle())
        .orElseThrow(()-> new ProductNotFoundException("El talle no fue encontrado"));
      

        servProducto.createProducto(producto.getId_producto(), producto.getNombre(), producto.getCantidad(),
                producto.getDescripcion(),
                categoria.getId_categoria(), producto.getPrecio(), color.getId_color(),talle.getId_talle());
        return "Guardado";
    }

    @GetMapping("/traer/{id}")
    public ProductoDTO getProducto(@PathVariable Long id) {
        ProductoDTO producto = servProducto.getProductoById(id);

        return producto;

    }

    @GetMapping("/traertodos")
    public List<Producto> getAllProductos() {

        List<Producto> listaProductos = servProducto.getAllProductos();

        return listaProductos;
    }

    @DeleteMapping("/eliminar/{id_producto}")
    public String DeleteProducto(@PathVariable Long id_producto) {


            servProducto.deleteProduto(id_producto);

            return "Producto eliminado correctamente";
        }
    

}
