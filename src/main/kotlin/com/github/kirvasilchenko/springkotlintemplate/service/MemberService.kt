package com.github.kirvasilchenko.springkotlintemplate.service

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberResponseDTO
import java.util.UUID


interface MemberService {

    fun getAllMembers(): List<MemberResponseDTO>

    fun getMemberById(id: UUID): MemberResponseDTO

    fun createMember(memberDTO: MemberRequestDTO): MemberResponseDTO

    fun updateMember(id: UUID, memberDTO: MemberRequestDTO): MemberResponseDTO

    fun deleteMember(id: UUID): Unit

}