package com.github.kirvasilchenko.springkotlintemplate.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Пользователь")
data class MemberRequestDTO(
    @Schema(description = "Имя")
    val firstname: String,
    @Schema(description = "Фамилия")
    val lastname: String,

    val middlename: String? = null,
    val phone: String,
    val email: String,
)