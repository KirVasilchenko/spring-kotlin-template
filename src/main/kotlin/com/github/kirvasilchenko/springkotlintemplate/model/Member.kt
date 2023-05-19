package com.github.kirvasilchenko.springkotlintemplate.model

import jakarta.persistence.*
import java.util.*

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