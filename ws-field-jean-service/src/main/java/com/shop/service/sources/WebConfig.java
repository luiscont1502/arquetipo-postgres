package com.shop.service.sources;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@PropertySource({"classpath:application.properties"})
@Log4j2
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Authorization")
                .allowCredentials(true)
                .allowedOriginPatterns("*")  // Cambia esto según tus necesidades, puedes especificar orígenes específicos en lugar de "*"
                .maxAge(3600);
    }

}
