package com.negocio.producto_service.service.Interfaces;

import com.negocio.producto_service.model.Color;

public interface IColorService {
    public String SaveColor(Color color);

    public String deleteColor(Long id);

    public Color getColorById(Long id);
}
