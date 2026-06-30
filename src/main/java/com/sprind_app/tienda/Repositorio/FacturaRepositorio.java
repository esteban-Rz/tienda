package com.sprind_app.tienda.Repositorio;

import com.sprind_app.tienda.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    // Buscar una factura por su número
    Optional<Factura> findByNumero(Integer numero);
}

