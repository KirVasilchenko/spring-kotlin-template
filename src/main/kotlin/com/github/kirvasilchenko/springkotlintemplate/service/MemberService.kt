package com.github.kirvasilchenko.springkotlintemplate.service

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDTO
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import java.util.*


interface MemberService {

    fun getAllMembers(): List<Member>

    fun getMemberById(id: UUID): Member

    fun createMember(memberDTO: MemberDTO): Member

    fun updateMember(id: UUID, memberDTO: MemberDTO): Member

    fun deleteMember(id: UUID): Unit

}