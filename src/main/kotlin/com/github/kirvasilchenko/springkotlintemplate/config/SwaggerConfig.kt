package com.github.kirvasilchenko.springkotlintemplate.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Example API server",
        version = "0.0.1-SNAPSHOT"
    )
)
class SwaggerConfig {

}