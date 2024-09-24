package ru.ushakov.minimalservice.user.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.ushakov.minimalservice.user.domain.User
import ru.ushakov.minimalservice.user.repository.UserRepository
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User {
        val existingUser = userRepository.findByUsername(user.username)
        if (existingUser != null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Username is already taken")
        }

        return userRepository.save(user)
    }

    fun getUserById(userId: Long): Optional<User> {
        return userRepository.findById(userId)
    }

    fun updateUser(userId: Long, updatedUser: User): Optional<User> {
        val user = userRepository.findById(userId)
        if (user.isPresent) {
            val currentUser = user.get().copy(
                firstName = updatedUser.firstName,
                lastName = updatedUser.lastName,
                email = updatedUser.email,
                phone = updatedUser.phone
            )
            return Optional.of(userRepository.save(currentUser))
        }
        return Optional.empty()
    }

    fun deleteUser(userId: Long) {
        userRepository.deleteById(userId)
    }
}