package com.github.kirvasilchenko.springkotlintemplate.service.impl

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.exception.MemberNotFoundException
import com.github.kirvasilchenko.springkotlintemplate.mapper.MemberMapper
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import com.github.kirvasilchenko.springkotlintemplate.repository.MemberRepository
import com.github.kirvasilchenko.springkotlintemplate.service.MemberService
import lombok.RequiredArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@RequiredArgsConstructor
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val mapper: MemberMapper
) : MemberService {

    override fun getAllMembers(): List<MemberShortResponseDTO> {
        return mapper.mapToShort(memberRepository.findAll())
    }

    override fun getMemberById(id: UUID): MemberDetailsResponseDTO {
        return mapper.mapToDetailed(findById(id))
    }

    override fun createMember(memberDTO: MemberRequestDTO): MemberDetailsResponseDTO {
        return saveAndReturn(mapper.mapToModel(memberDTO))
    }

    override fun updateMember(id: UUID, memberDTO: MemberRequestDTO): MemberDetailsResponseDTO {
        val existingMember = findById(id)
        return saveAndReturn(mapper.updateWithDto(existingMember, memberDTO))
    }

    override fun deleteMember(id: UUID): MemberDetailsResponseDTO {
        memberRepository.deleteSoftById(id)
        return mapper.mapToDetailed(findById(id))
    }

    private fun findById(id: UUID): Member {
        return memberRepository.findByIdOrNull(id) ?: throw MemberNotFoundException()
    }

    private fun saveAndReturn(member: Member): MemberDetailsResponseDTO {
        return mapper.mapToDetailed(memberRepository.save(member))
    }

}