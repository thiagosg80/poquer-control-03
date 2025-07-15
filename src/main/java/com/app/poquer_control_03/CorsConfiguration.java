package com.app.poquer_control_03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                final String allowedOrigins = "*";

                registry.addMapping("/*/*")
                        .allowedOrigins(allowedOrigins);

                registry.addMapping("/*/*/*")
                        .allowedOrigins(allowedOrigins);
            }
        };
    }
}
