package br.com.equipeWeg.ProjetoLoginCost.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Permitir CORS apenas para rotas que começam com /api/
                .allowedOrigins("http://localhost:5173")  // URL do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Permitir qualquer cabeçalho
                .allowCredentials(true);  // Permitir credenciais (como cookies, por exemplo)
    }
}
