package ru.ushakov.minimalservice.user.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ushakov.minimalservice.user.domain.User
import ru.ushakov.minimalservice.user.domain.UserDto
import ru.ushakov.minimalservice.user.service.UserService

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@Valid @RequestBody userDto: UserDto): ResponseEntity<User> {
        val newUser = User(
            username = userDto.username,
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            email = userDto.email,
            phone = userDto.phone
        )
        return ResponseEntity(userService.createUser(newUser), HttpStatus.CREATED)
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: Long): ResponseEntity<User> {
        val user = userService.getUserById(userId)
        return user.map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Long, @Valid @RequestBody userDto: UserDto): ResponseEntity<User> {
        val updatedUser = User(
            id = userId,
            username = userDto.username,
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            email = userDto.email,
            phone = userDto.phone
        )
        return userService.updateUser(userId, updatedUser)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Unit> {
        userService.deleteUser(userId)
        return ResponseEntity.noContent().build()
    }
}