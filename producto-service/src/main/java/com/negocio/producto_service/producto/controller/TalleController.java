package com.negocio.producto_service.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.producto_service.producto.model.Talle;
import com.negocio.producto_service.producto.service.interfaces.ITalleService;

@RestController
@RequestMapping("/talle")
public class TalleController {
    @Autowired
    private ITalleService servTalle;

    @PostMapping("/crear")
    public String createTalle(@RequestBody Talle talle) {

        servTalle.SaveTalle(talle);

        return "Talle guardado";
    }

    @GetMapping("/traer/{id}")
    public Talle getTalle(@PathVariable Long id_talle) {
        Talle talle = servTalle.getTalleById(id_talle);
        return talle;
    }

    @DeleteMapping("/eliminar/{id}")

    public String deleteTalle(@PathVariable Long id_talle) {

        servTalle.deleteTalle(id_talle);
        return "Talle eliminado on exito";
    }
}
