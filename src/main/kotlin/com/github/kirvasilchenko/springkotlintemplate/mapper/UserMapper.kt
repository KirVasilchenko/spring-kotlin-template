package com.github.kirvasilchenko.springkotlintemplate.mapper

import com.github.kirvasilchenko.springkotlintemplate.dto.UserDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.model.User
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import java.time.LocalDateTime

@Mapper(componentModel = "spring")
abstract class UserMapper {

    abstract fun mapToShort(source: User): UserShortResponseDTO
    abstract fun mapToShort(source: List<User>): List<UserShortResponseDTO>
    abstract fun mapToDetailed(source: User): UserDetailsResponseDTO

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", constant = "true")
    abstract fun mapToModel(source: UserRequestDTO): User

    fun updateWithDto(@MappingTarget model: User, dto: UserRequestDTO): User = model.copy(
        firstname = dto.firstname,
        lastname = dto.lastname,
        middlename = dto.middlename,
        email = dto.email,
        phone = dto.phone,
        updatedAt = LocalDateTime.now()
    )

}