package com.sprind_app.tienda.Repositorio;

import com.sprind_app.tienda.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,Long> {
}
