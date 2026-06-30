package com.sprind_app.tienda.servicio;

import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.Entidad.Usuario;
import com.sprind_app.tienda.Repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> buscarCliente(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    // Obtener productos de un cliente por su ID
    public List<Producto> buscarProductosPorClienteId(Long usuarioId) {
        return usuarioRepositorio.findById(usuarioId)
                .map(Usuario::obtenerProductos) // suponiendo que Usuario tiene un m
                .orElse(List.of());
    }
}

