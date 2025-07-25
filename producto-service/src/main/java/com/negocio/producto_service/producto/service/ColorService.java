package com.negocio.producto_service.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.producto_service.producto.model.Color;
import com.negocio.producto_service.producto.repositoy.IColorRepository;
import com.negocio.producto_service.producto.service.interfaces.IColorService;
@Service
public class ColorService implements IColorService {

    @Autowired
    private IColorRepository repo;

    @Override
    public String SaveColor(Color color) {
        if (color.getNombre() == null || color.getNombre().isEmpty()) {
            return "El nombre del color no puede estar vacío";
        }
        repo.save(color);
        return "Color guardado correctamente";

    }

    @Override
    public String deleteColor(Long id) {

        repo.deleteById(id);
        return "Color eliminado correctamente";
    }

    @Override
    public Color getColorById(Long id) {
        Color color = repo.findById(id).orElse(null);

        return color;
    }

}
