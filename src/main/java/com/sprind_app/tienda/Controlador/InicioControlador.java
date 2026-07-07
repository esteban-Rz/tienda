package com.sprind_app.tienda.Controlador;

import com.sprind_app.tienda.Entidad.UsuarioWeb;
import com.sprind_app.tienda.Seguridad.Miexcepcion;
import com.sprind_app.tienda.servicio.UsuarioWebServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // o @Controller, según cómo esté anotada la clase arriba (no se ve en la captura)
public class InicioControlador {

    @Autowired
    private UsuarioWebServicio usuarioWebServicio;

    @GetMapping("/registrar")
    public String formularioUsuario() {
        return "/Producto/Usuario/FormularioUsuarioWeb";
    }

    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String password2,
            Model model) {

        try {
            usuarioWebServicio.registrarUsuario(nombre, email, password, password2);
            model.addAttribute("exito", "Usuario registrado con éxito");
            return "index";
        } catch (Miexcepcion e) {
            model.addAttribute("error", e.getMessage());
            return "/Producto/Usuario/FormularioUsuarioWeb";
        }
    }
}
