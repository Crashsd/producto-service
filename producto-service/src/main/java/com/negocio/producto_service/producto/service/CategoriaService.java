package com.negocio.producto_service.producto.service;

import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.producto_service.producto.model.Categoria;
import com.negocio.producto_service.producto.repositoy.ICategoriaRepository;
import com.negocio.producto_service.producto.service.interfaces.ICategoriaService;
@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository repo;

    @Override
    public String SaveCategoria(Categoria categoria) {

        
       repo.save(categoria);

       if(categoria.getNombre().isBlank()){
        throw new IllegalArgumentException("El nombre de la categoria no puede estar vacio");
       }

       return "Categoria guardada";
    }

    @Override
    public String deleteCategoria(Long id) {
        repo.deleteById(id);
        return "Categoria eliminada";

    }

    @Override
    public Categoria getCategoriaById(Long id) {
        Categoria categoria=repo.findById(id).orElse(null);

       return categoria;

        
    }

    @Override
    public Categoria findByNombre(String nombre) {
        if(nombre.equals(null)){
            throw new NullArgumentException("Nombre no encontrado");
        }else{

            repo.findByNombre(nombre);
        }
        
        return null;
    }

}
