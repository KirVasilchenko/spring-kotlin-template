package com.github.kirvasilchenko.springkotlintemplate.model

import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.util.UUID

@Entity
@Table(name = "member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,

    @Column(name = "firstname", nullable = false)
    val firstname: String,

    @Column(name = "lastname", nullable = false)
    val lastname: String
)