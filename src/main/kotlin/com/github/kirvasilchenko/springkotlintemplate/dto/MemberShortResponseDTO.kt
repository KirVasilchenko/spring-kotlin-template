package com.github.kirvasilchenko.springkotlintemplate.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@Schema(description = "Пользователь")
data class MemberShortResponseDTO(
    @Schema(description = "ID")
    val id: UUID,
    @Schema(description = "Имя")
    val firstname: String,
    @Schema(description = "Фамилия")
    val lastname: String
)