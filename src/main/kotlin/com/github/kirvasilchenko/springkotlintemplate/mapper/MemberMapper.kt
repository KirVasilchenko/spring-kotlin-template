package com.github.kirvasilchenko.springkotlintemplate.mapper

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import java.time.LocalDateTime

@Mapper(componentModel = "spring")
abstract class MemberMapper {

    abstract fun mapToShort(source: Member): MemberShortResponseDTO
    abstract fun mapToShort(source: List<Member>): List<MemberShortResponseDTO>
    abstract fun mapToDetailed(source: Member): MemberDetailsResponseDTO

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "active", constant = "true")
    abstract fun mapToModel(source: MemberRequestDTO): Member

    fun updateWithDto(@MappingTarget model: Member, dto: MemberRequestDTO): Member = model.copy(
        firstname = dto.firstname,
        lastname = dto.lastname,
        middlename = dto.middlename,
        email = dto.email,
        phone = dto.phone,
        updatedAt = LocalDateTime.now()
    )

}