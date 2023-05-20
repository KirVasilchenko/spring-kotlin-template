package com.github.kirvasilchenko.springkotlintemplate.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Example API server",
        version = "0.0.1-SNAPSHOT",
        contact = Contact(
            name = "Kir Vasilchenko",
            url = "https://github.com/kirvasilchenko",
            email = "cyrus.ex.machina@gmail.com"
        )
    )
)
class SwaggerConfig {

}