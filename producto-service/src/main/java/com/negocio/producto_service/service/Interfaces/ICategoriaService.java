package com.negocio.producto_service.service.Interfaces;

import com.negocio.producto_service.model.Categoria;

public interface ICategoriaService {

    public String SaveCategoria(Categoria categoria);

    public String deleteCategoria(Long id);

    public Categoria getCategoriaById(Long id);

    public Categoria findByNombre(String nombre);
}
