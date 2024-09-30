package ru.ushakov.minimalservice.user.controller

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateUserRequest(

    @NotBlank
    val firstName: String,

    @NotBlank
    val lastName: String,

    @NotBlank
    val phone: String
)
