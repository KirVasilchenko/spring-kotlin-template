package com.github.kirvasilchenko.springkotlintemplate.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = UUID.randomUUID(),

    @Column(name = "firstname", nullable = false)
    val firstname: String,

    @Column(name = "lastname", nullable = false)
    val lastname: String,

    @Column(name = "middlename", nullable = true)
    val middlename: String?,

    @Column(name = "phone", nullable = false)
    val phone: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime,

    @Column(name = "active", nullable = false)
    val active: Boolean,

    @Column(name = "deleted_at", nullable = true)
    val deletedAt: LocalDateTime?,
) {

}