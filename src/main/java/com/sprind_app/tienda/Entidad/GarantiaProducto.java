package com.sprind_app.tienda.Entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GarantiaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    @Column(nullable = true)
    private String descripcion;
    private Integer duracion ;
    // realacion 1 a 1 entre garantia y producto

}
