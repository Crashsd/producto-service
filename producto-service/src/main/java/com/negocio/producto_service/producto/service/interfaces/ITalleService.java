package com.negocio.producto_service.producto.service.interfaces;


import com.negocio.producto_service.producto.model.Talle;

public interface ITalleService {
    public String SaveTalle(Talle talle);

    public String deleteTalle(Long id_talle);

    public Talle getTalleById(Long id_talle);
}
