package net.quintoimpacto.ubuntuapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica la política CORS a todas las rutas
                .allowedOrigins("http://localhost:5173") // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization") // Encabezados permitidos
                .allowCredentials(true) // Permite credenciales
                .maxAge(3600); // Tiempo máximo que los navegadores deben cachear el resultado de una solicitud de pre-vuelo
    }
}