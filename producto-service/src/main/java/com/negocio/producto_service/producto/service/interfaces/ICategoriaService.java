package com.negocio.producto_service.producto.service.interfaces;

import com.negocio.producto_service.producto.model.Categoria;

public interface ICategoriaService {

    public String SaveCategoria(Categoria categoria);

    public String deleteCategoria(Long id);

    public Categoria getCategoriaById(Long id);

    public Categoria findByNombre(String nombre);
}
