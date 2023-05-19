package com.github.kirvasilchenko.springkotlintemplate.rest

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberDTO
import com.github.kirvasilchenko.springkotlintemplate.model.Member
import com.github.kirvasilchenko.springkotlintemplate.service.MemberService
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "MEMBERS", description = "Пользователи")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
class MemberController(

    private val memberService: MemberService

) {

    @GetMapping
    fun getAllMembers(): List<Member> {
        return memberService.getAllMembers()
    }

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: UUID): Member {
        return memberService.getMemberById(id)
    }

    @PostMapping
    fun createMember(@RequestBody memberDTO: MemberDTO): Member {
        return memberService.createMember(memberDTO)
    }

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: UUID, @RequestBody memberDTO: MemberDTO): Member {
        return memberService.updateMember(id, memberDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: UUID): Unit {
        return memberService.deleteMember(id)
    }

}