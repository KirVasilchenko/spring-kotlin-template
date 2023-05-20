package com.github.kirvasilchenko.springkotlintemplate.service.impl

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.exception.MemberNotFoundException
import com.github.kirvasilchenko.springkotlintemplate.mapper.MemberMapper
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import com.github.kirvasilchenko.springkotlintemplate.repository.MemberRepository
import com.github.kirvasilchenko.springkotlintemplate.service.MemberService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@RequiredArgsConstructor
class MemberServiceImpl(

    private val memberRepository: MemberRepository,
    private val mapper: MemberMapper

) : MemberService {

    override fun getAllMembers(): List<MemberResponseDTO> {
        return mapper.map(memberRepository.findAll())
    }

    override fun getMemberById(id: UUID): MemberResponseDTO {
        return mapper.map(memberRepository.findById(id).orElseThrow {
            MemberNotFoundException()
        })
    }

    override fun createMember(memberDTO: MemberRequestDTO): MemberResponseDTO {
        val member = Member(
            id = UUID.randomUUID(),
            firstname = memberDTO.firstname,
            lastname = memberDTO.lastname
        )
        return mapper.map(memberRepository.save(member))
    }

    override fun updateMember(id: UUID, memberDTO: MemberRequestDTO): MemberResponseDTO {
        val existingMember = memberRepository.findById(id).orElseThrow {
            MemberNotFoundException()
        }
        val updatedMember = Member(
            id = existingMember.id,
            firstname = memberDTO.firstname,
            lastname = memberDTO.lastname
        )
        return mapper.map(memberRepository.save(updatedMember))
    }

    override fun deleteMember(id: UUID) {
        memberRepository.deleteById(id)
    }

}