package com.github.kirvasilchenko.springkotlintemplate.service.impl

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.exception.MemberNotFoundException
import com.github.kirvasilchenko.springkotlintemplate.mapper.MemberMapper
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
        val member = memberRepository.findById(id).orElseThrow {
            MemberNotFoundException()
        }
        return mapper.mapToDetailed(member)
    }

    override fun createMember(memberDTO: MemberRequestDTO): MemberDetailsResponseDTO {
        val newMember = mapper.mapToModel(memberDTO)
        val savedMember = memberRepository.save(newMember)
        return mapper.mapToDetailed(savedMember)
    }

    override fun updateMember(id: UUID, memberDTO: MemberRequestDTO): MemberDetailsResponseDTO {
        val existingMember = memberRepository.findById(id).orElseThrow {
            MemberNotFoundException()
        }
        val updatedMember = mapper.updateWithDto(existingMember, memberDTO)
        return mapper.mapToDetailed(memberRepository.save(updatedMember))
    }

    override fun deleteMember(id: UUID): MemberDetailsResponseDTO {
        memberRepository.deleteSoftById(id)
        val deletedMember = memberRepository.findByIdOrNull(id) ?: throw MemberNotFoundException()
        return mapper.mapToDetailed(deletedMember)
    }

}