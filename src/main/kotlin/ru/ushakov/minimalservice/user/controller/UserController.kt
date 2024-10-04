package ru.ushakov.minimalservice.user.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ushakov.minimalservice.user.domain.User
import ru.ushakov.minimalservice.user.domain.UserDto
import ru.ushakov.minimalservice.user.service.UserService

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping
    fun createUser(@Valid @RequestBody userDto: UserDto): ResponseEntity<User> {
        log.info("Request for user creation: $userDto")
        val newUser = User(
            id = userDto.id,
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            phone = userDto.phone
        )
        return ResponseEntity(userService.createUser(newUser), HttpStatus.CREATED)
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: Long): ResponseEntity<User> {
        log.info("Request for user: $userId")
        val user = userService.getUserById(userId)
        return user.map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Long, @Valid @RequestBody request: UpdateUserRequest): ResponseEntity<User> {
        log.info("Request for user update: $request")
        val updatedUser = User(
            id = userId,
            firstName = request.firstName,
            lastName = request.lastName,
            phone = request.phone
        )
        return userService.updateUser(userId, updatedUser)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Unit> {
        log.info("Request for user deletion: $userId")
        userService.deleteUser(userId)
        return ResponseEntity.noContent().build()
    }
}