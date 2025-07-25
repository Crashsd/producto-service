package com.negocio.producto_service.producto.service.interfaces;

import com.negocio.producto_service.producto.model.Color;

public interface IColorService {
    public String SaveColor(Color color);

    public String deleteColor(Long id);

    public Color getColorById(Long id);
}
