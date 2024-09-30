package ru.ushakov.minimalservice.user.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UserDto(

    @NotNull
    val id: Long,

    @NotBlank
    val firstName: String,

    @NotBlank
    val lastName: String,

    @NotBlank
    val phone: String
)