package com.github.kirvasilchenko.springkotlintemplate.service.impl

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDTO
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import com.github.kirvasilchenko.springkotlintemplate.repository.MemberRepository
import com.github.kirvasilchenko.springkotlintemplate.service.MemberService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
@RequiredArgsConstructor
class MemberServiceImpl(

    private val memberRepository: MemberRepository

) : MemberService {

    override fun getAllMembers(): List<Member> {
        return memberRepository.findAll()
    }

    override fun getMemberById(id: UUID): Member {
        return memberRepository.findById(id).orElseThrow {
            NoSuchElementException("Member with id $id not found")
        }
    }

    override fun createMember(memberDTO: MemberDTO): Member {
        val member = Member(
            id = UUID.randomUUID(),
            firstname = memberDTO.firstname,
            lastname = memberDTO.lastname
        )
        return memberRepository.save(member)
    }

    override fun updateMember(id: UUID, memberDTO: MemberDTO): Member {
        val existingMember = memberRepository.findById(id).orElseThrow {
            NoSuchElementException("Member with id $id not found")
        }
        val updatedMember = Member(
            id = existingMember.id,
            firstname = memberDTO.firstname,
            lastname = memberDTO.lastname
        )
        return memberRepository.save(updatedMember)
    }

    override fun deleteMember(id: UUID): Unit {
        memberRepository.deleteById(id)
    }

}