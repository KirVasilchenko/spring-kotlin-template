package com.github.kirvasilchenko.springkotlintemplate.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Пользователь")
data class MemberDTO(
    @Schema(description = "Имя")
    val firstname: String,
    @Schema(description = "Фамилия")
    val lastname: String
)