package com.sprind_app.tienda.Seguridad;

import com.sprind_app.tienda.servicio.UsuarioWebServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SeguridadWeb {
    @Autowired
    private UsuarioWebServicio usuarioWebServicio;

    @Autowired
    private PasswordEncoder passwordEncoder; // ahora viene de la nueva clase, sin ciclo

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Público
                        .requestMatchers(
                                "/css/**", "/js/**", "/img/**",
                                "/registrar", "/registro",
                                "/productos", "/facturas"
                        ).permitAll()

                        // Solo administradores: gestión de productos
                        .requestMatchers(
                                "/formulario", "/guardar", "/editar/**", "/eliminar/**", "/facturas"
                        ).hasRole("ADMIN")

                        // Todo lo demás requiere estar logueado
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(usuarioWebServicio);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
