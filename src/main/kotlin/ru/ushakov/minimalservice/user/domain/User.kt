package ru.ushakov.minimalservice.user.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    val id: Long,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    val phone: String
)
