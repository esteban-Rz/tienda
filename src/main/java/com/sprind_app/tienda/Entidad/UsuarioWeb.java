package com.sprind_app.tienda.Entidad;

import com.sprind_app.tienda.roles.Roll;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class UsuarioWeb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nombre ;
    private String email ;
    private String password ;
    @Enumerated (EnumType.STRING)

    private Roll roll;


}
