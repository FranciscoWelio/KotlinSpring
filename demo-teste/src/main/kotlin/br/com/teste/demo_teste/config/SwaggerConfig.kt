package br.com.teste.demo_teste.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {
    @Bean
    fun CustomAPI(): OpenAPI {
        return OpenAPI().info(Info().title("Swagger Desafio Técnico").version("1.0.0"))
    }

}