package com.github.kirvasilchenko.springkotlintemplate.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Пользователь. Детальная информация")
data class UserDetailsResponseDTO(

    @Schema(description = "ID")
    val id: UUID,

    @Schema(description = "Имя")
    val firstname: String,

    @Schema(description = "Фамилия")
    val lastname: String,

    @Schema(description = "Отчество")
    val middlename: String?,

    @Schema(description = "Номер телефона")
    val phone: String,

    @Schema(description = "Email")
    val email: String,

    @Schema(description = "Дата создания")
    val createdAt: LocalDateTime,

    @Schema(description = "Дата обновления")
    val updatedAt: LocalDateTime,

    @Schema(description = "Активен")
    val active: Boolean,

    @Schema(description = "Дата удаления")
    val deletedAt: LocalDateTime?,
)