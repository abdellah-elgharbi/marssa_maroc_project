package com.marsa_maroc.gestion_des_prestation.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final RsaConfig rsaConfig;

    public SecurityConfig( RsaConfig rsaConfig) {

        this.rsaConfig = rsaConfig;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return  http
                .csrf(csrf -> csrf.disable()) // désactiver CSRF
                .authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll().anyRequest().authenticated()) // autoriser toutes les requêtes
                .formLogin(form -> form.disable()) // désactiver le formulaire de login
                .httpBasic(basic -> basic.disable()).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())).build();
        

    }

    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(rsaConfig.publicKey()).build();
    }
}
