package com.sprind_app.tienda.servicio;

import com.sprind_app.tienda.Entidad.Producto;
import com.sprind_app.tienda.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

// se hace el crud . logica de negocio
@Service
public class ProductoServicio {
    @Autowired // inyección las dependencia por campo
    ProductoRepositorio productoRepositorio ;

    public List<Producto> listarproducto (){
        return productoRepositorio.findAll() ; // productos
    }
    public List<Producto> buscarProductoNombre (String buscarProducto) {
        if (buscarProducto == null  || buscarProducto.isEmpty()){
            return productoRepositorio.findAll();
        } else {
            return productoRepositorio.findByNombreContainingIgnoreCase(buscarProducto);

        }
    }
    public Optional<Producto> buscarProducto (Long id){

        return productoRepositorio.findById(id);
    }
    public  void  guardarProducto (Producto producto){
        productoRepositorio.save(producto);
    }
    public  void eliminarProducto (Long id) {
        productoRepositorio.deleteById(id);
    }

}
