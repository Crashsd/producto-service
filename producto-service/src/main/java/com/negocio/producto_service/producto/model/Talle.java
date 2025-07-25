package com.negocio.producto_service.producto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Talle {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_talle;
@Column(nullable = false ,unique = true)
private String nombre;
}
