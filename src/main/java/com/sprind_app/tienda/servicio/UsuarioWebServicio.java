package com.sprind_app.tienda.servicio;

import com.sprind_app.tienda.Entidad.UsuarioWeb;
import com.sprind_app.tienda.Repositorio.UsurioWebRepositorio;
import com.sprind_app.tienda.Seguridad.Miexcepcion;
import com.sprind_app.tienda.roles.Roll;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioWebServicio  implements UserDetailsService {



        @Autowired
        private UsurioWebRepositorio usurioWebRepositorio;

        @Autowired
        private PasswordEncoder passwordEncoder; // Bean de BCryptPasswordEncoder

    @Transactional
    public void registrarUsuario(String nombre, String email, String password, String password2) throws Miexcepcion {

        if (!password.equals(password2)) {
            throw new Miexcepcion("Las contraseñas no coinciden");
        }

        if (usurioWebRepositorio.buscarUsuarioByEmail(email) != null) {
            throw new Miexcepcion("Ya existe un usuario registrado con ese correo");
        }

        UsuarioWeb usuario = new UsuarioWeb();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setRoll(Roll.USER);
        usurioWebRepositorio.save(usuario);
    }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            UsuarioWeb usuario = usurioWebRepositorio.buscarUsuarioByEmail(email);
            if (usuario != null) {
                List<GrantedAuthority> permisos = new ArrayList<>();
                GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRoll().toString());
                permisos.add(p);
                return new User(usuario.getEmail(), usuario.getPassword(), permisos);
            } else {
                throw new UsernameNotFoundException("No existe un usuario con el email: " + email);
            }
        }
    }

