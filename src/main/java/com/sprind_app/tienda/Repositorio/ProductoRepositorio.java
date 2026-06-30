package com.sprind_app.tienda.Repositorio;


import com.sprind_app.tienda.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // conecta con la base de datos
public interface ProductoRepositorio  extends JpaRepository <Producto,Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
