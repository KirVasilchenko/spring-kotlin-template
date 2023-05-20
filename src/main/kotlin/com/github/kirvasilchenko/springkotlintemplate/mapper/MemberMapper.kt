package com.github.kirvasilchenko.springkotlintemplate.mapper

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MemberMapper {

    fun map(source: Member): MemberResponseDTO
    fun map(source: List<Member>): List<MemberResponseDTO>
    fun map(source: MemberResponseDTO): Member

}