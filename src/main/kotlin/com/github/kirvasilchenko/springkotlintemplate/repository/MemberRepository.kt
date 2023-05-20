package com.github.kirvasilchenko.springkotlintemplate.repository

import com.github.kirvasilchenko.springkotlintemplate.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MemberRepository : JpaRepository<Member, UUID> {

}