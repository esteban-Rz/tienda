package com.sprind_app.tienda.Repositorio;

import com.sprind_app.tienda.Entidad.Usuario;
import com.sprind_app.tienda.Entidad.UsuarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsurioWebRepositorio extends JpaRepository<UsuarioWeb,Long> {
    // consulta personal
    @Query("SELECT u FROM UsuarioWeb u WHERE u.email = :email")
    UsuarioWeb buscarUsuarioByEmail(@Param("email") String email);
}
