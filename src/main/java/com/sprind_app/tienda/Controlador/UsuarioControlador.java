package com.sprind_app.tienda.Controlador;


import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.Entidad.Usuario;
import com.sprind_app.tienda.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/usuario")
    public String mostrarUsuario(Model model) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        model.addAttribute("usuarioLista", usuarios);
        return "/Producto/Usuario/listaUsuario";
    }

    @GetMapping("/formularioUsuario")
    public String formularioUsuario(Model model) {
        model.addAttribute("usuario", new Usuario()); // nombre correcto
        return "/Producto/Usuario/formularioUsuario";
    }

    @GetMapping("/productos/{usuarioId}")
    public String mostrarComprasUsuario(@PathVariable Long usuarioId,Model model) {
        List<Producto> productos = usuarioServicio.buscarProductosPorClienteId(usuarioId);
        model.addAttribute("productos", productos);
        return "/Producto/Usuario/listaCompras";
    }

    @PostMapping("/guardarUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/usuario"; // coincide con listado
    }

    @PostMapping("/guardarCompras")
    public String crearCompraUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/listaCompraUsuario"; // coincide con listado
    }
}

