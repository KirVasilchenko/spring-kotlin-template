package com.github.kirvasilchenko.springkotlintemplate.service

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberShortResponseDTO
import java.util.UUID


interface MemberService {

    fun getAllMembers(): List<MemberShortResponseDTO>

    fun getMemberById(id: UUID): MemberDetailsResponseDTO

    fun createMember(memberDTO: MemberRequestDTO): MemberDetailsResponseDTO

    fun updateMember(id: UUID, memberDTO: MemberRequestDTO): MemberDetailsResponseDTO

    fun deleteMember(id: UUID): MemberDetailsResponseDTO

}