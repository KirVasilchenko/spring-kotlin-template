package com.github.kirvasilchenko.springkotlintemplate.repository

import com.github.kirvasilchenko.springkotlintemplate.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface MemberRepository : JpaRepository<Member, UUID> {

    @Transactional
    @Modifying
    @Query(
        """
        UPDATE Member m SET
        m.updatedAt = :dateTime,
        m.deletedAt = :dateTime,
        m.active = false
        WHERE m.id = :id
        """
    )
    fun deleteSoftById(id: UUID, dateTime: LocalDateTime = LocalDateTime.now()): Int

}