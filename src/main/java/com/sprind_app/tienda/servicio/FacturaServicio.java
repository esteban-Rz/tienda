package com.sprind_app.tienda.servicio;


import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    // Buscar productos de una factura por su número
    public List<Producto> buscarProductosPorNumeroFactura(Integer numeroFactura) {
        return facturaRepositorio.findByNumero(numeroFactura)
                .map(factura -> List.of(factura.getProducto())) // devuelve el producto en una lista
                .orElse(List.of()); // si no existe la factura, lista vacía
    }
}
