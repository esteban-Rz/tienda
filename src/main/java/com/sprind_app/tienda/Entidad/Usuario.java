package com.sprind_app.tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String cedula;
    private String direccion;
    private int compra;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;

    // Método para obtener productos a través de las facturas

    public List<Producto> obtenerProductos() {
        return facturas.stream()
                .map(Factura::getProducto)
                .toList();
    }
}
