package com.sprind_app.tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer numero;
    private Double precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}