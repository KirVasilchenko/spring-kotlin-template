package com.github.kirvasilchenko.springkotlintemplate.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.*

@Schema(description = "Пользователь. Детальная информация")
@JsonInclude(Include.NON_NULL)
data class UserDetailsResponseDTO(

    @Schema(description = "ID")
    val id: UUID,

    @Schema(description = "Имя")
    val firstname: String,

    @Schema(description = "Фамилия")
    val lastname: String,

    @Schema(description = "Отчество")
    //@JsonInclude(Include.NON_NULL)
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
    //@JsonInclude(Include.NON_NULL)
    val deletedAt: LocalDateTime?,
)