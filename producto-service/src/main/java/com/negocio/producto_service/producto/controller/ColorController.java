package com.negocio.producto_service.producto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.producto_service.producto.model.Color;
import com.negocio.producto_service.producto.service.interfaces.IColorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private IColorService servColor;

    @PostMapping("/crear")
    public String createColor(@RequestBody Color color) {
        servColor.SaveColor(color);
        return "Color guardado";
    }

    @DeleteMapping("/eliminar/{id_color}")
    public String DeleteColor(@PathVariable Long id_color) {
        servColor.deleteColor(id_color);
        return "Color eliminado con exito";
    }

    @GetMapping("/traer/{id_color}")
    public Color getColor(@PathVariable Long id_color) {
        return servColor.getColorById(id_color);
    }

}
