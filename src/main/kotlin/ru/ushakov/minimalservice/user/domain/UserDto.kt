package ru.ushakov.minimalservice.user.domain

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserDto(
    @NotBlank
    val username: String,

    @NotBlank
    val firstName: String,

    @NotBlank
    val lastName: String,

    @Email
    @NotBlank
    val email: String,

    @NotBlank
    val phone: String
)