package com.sprind_app.tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity // entidad
 //@Table (name = "tabla_producto") // cambia el nombre
public class Producto {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private double precio;
    private int stock;

    @OneToMany(mappedBy = "producto")
    private List<Factura> facturas;
}

