package com.github.kirvasilchenko.springkotlintemplate.rest

import com.github.kirvasilchenko.springkotlintemplate.dto.MemberRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.MemberResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.service.MemberService
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "MEMBERS", description = "Пользователи")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
class MemberController(

    private val memberService: MemberService

) {

    @GetMapping
    fun getAllMembers(): List<MemberResponseDTO> {
        return memberService.getAllMembers()
    }

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: UUID): MemberResponseDTO {
        return memberService.getMemberById(id)
    }

    @PostMapping
    fun createMember(@RequestBody memberDTO: MemberRequestDTO): MemberResponseDTO {
        return memberService.createMember(memberDTO)
    }

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: UUID, @RequestBody memberDTO: MemberRequestDTO): MemberResponseDTO {
        return memberService.updateMember(id, memberDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: UUID): Unit {
        return memberService.deleteMember(id)
    }

}