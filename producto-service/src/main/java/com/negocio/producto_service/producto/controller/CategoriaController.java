package com.negocio.producto_service.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.producto_service.producto.model.Categoria;
import com.negocio.producto_service.producto.service.interfaces.ICategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
@Autowired
private ICategoriaService service;

@PostMapping("/crear")
public String createCategoria(@RequestBody Categoria categoria){

    service.SaveCategoria(categoria);

    return"Categoria guardada";
}
}
