package ru.ushakov.minimalservice.user.domain

import jakarta.validation.constraints.Email

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Email
    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val phone: String
)
