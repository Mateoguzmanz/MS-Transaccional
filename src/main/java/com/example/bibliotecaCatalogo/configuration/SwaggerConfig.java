package com.example.bibliotecaCatalogo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para el servicio de Biblioteca", version = "1.0",description = "Api de los enpoints"))
public class SwaggerConfig {

}
