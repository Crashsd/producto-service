package com.negocio.producto_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.producto_service.model.Talle;
import com.negocio.producto_service.repository.ITalleRepository;
import com.negocio.producto_service.service.Interfaces.ITalleService;

@Service
public class TalleService implements ITalleService {
@Autowired
private ITalleRepository repoTalle;
    @Override
    public String SaveTalle(Talle talle) {
        repoTalle.save(talle);
        return "Talle guardado";
    }

    @Override
    public String deleteTalle(Long id_talle) {
        repoTalle.deleteById(id_talle);

        return "Talle eliminado";
    }

    @Override
    public Talle getTalleById(Long id_talle) {
       
        Talle talle =repoTalle.findById(id_talle).orElse(null);
        return talle;
    }

}
