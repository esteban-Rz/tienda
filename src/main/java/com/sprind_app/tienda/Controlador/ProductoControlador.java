package com.sprind_app.tienda.Controlador;

import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoControlador {
    @Autowired //  inyeccion de independencia
    ProductoServicio productoServicio ;
    // leer y buscar por nombre
    @GetMapping ("/productos")
    public String mostrarProducto (@RequestParam(name = "buscarProducto", required = false,defaultValue = "")
                                       String buscarProducto , Model model){
        List<Producto> productos =productoServicio.buscarProductoNombre(buscarProducto);
        model.addAttribute("buscarProducto",buscarProducto);
        model.addAttribute("productos",productos);
        return "/Producto/listaProductos";
    }
    //crear
    @GetMapping("/formulario")
    public String FormularioPrductos (Model model){
        model.addAttribute("producto", new Producto());
        return  "/Producto/formulario";
    }
    @PostMapping ("/guardar")
    public String crearProducto (Producto producto) {
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }
    // actulizar
    @GetMapping ("/editar/{id}")
    public String editarProducto (@PathVariable long id , Model model){
        Optional <Producto> producto = productoServicio.buscarProducto(id);
        model.addAttribute("producto", producto);
        return "/Producto/formulario";
    }
    //eliminar
    @GetMapping ("/eliminar/{id}")
    public  String eliminarProducto (@PathVariable Long id){
        productoServicio.eliminarProducto(id);
        return "rendirect: /productos";
    }

}
