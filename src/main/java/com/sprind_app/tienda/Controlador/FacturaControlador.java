package com.sprind_app.tienda.Controlador;

import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FacturaControlador {
    @Autowired
    private FacturaServicio facturaServicio;
    @GetMapping("/facturas")
    public  String buscarProductoporFactura (@RequestParam(value = "numeroFactura" ,required = false)
                                                 Integer numeroFactura, Model model) {
        if(numeroFactura != null){
             List<Producto> productos = facturaServicio.buscarProductosPorNumeroFactura(numeroFactura);
             model.addAttribute("productos",productos);
        }
        return "factura/VistaFacturas";
    }
}
