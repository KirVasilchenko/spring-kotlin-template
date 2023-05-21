package com.github.kirvasilchenko.springkotlintemplate.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern

@Schema(description = "Пользователь")
class UserRequestDTO(

    @Schema(description = "Имя")
    @field: NotBlank(message = "Имя не может быть пустым")
    val firstname: String,

    @Schema(description = "Фамилия")
    @field: NotBlank(message = "Фамилия не может быть пустой")
    val lastname: String,

    @Schema(description = "Отчество")
    @field: NotEmpty(message = "Отчество не может быть пустым. Используйте null, если отчества нет")
    val middlename: String? = null,

    @Schema(description = "Номер телефона")
    @field: NotBlank(message = "Номер телефона не может быть пустым")
    @field: Pattern(regexp = "7[0-9]{10}$", message = "Неверный формат номера телефона")
    val phone: String,

    @Schema(description = "Адрес электронной почты")
    @field: NotBlank(message = "Адрес электронной почты не может быть пустым")
    @field: Email(message = "Неверный формат электронной почты")
    val email: String,
)