package com.github.kirvasilchenko.springkotlintemplate.rest

import com.github.kirvasilchenko.springkotlintemplate.dto.UserDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.monitor.UserRequestsMonitoring
import com.github.kirvasilchenko.springkotlintemplate.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.annotation.PostConstruct
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "USERS", description = "Пользователи")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
class UserController(

    private val userService: UserService,
    private val userRequestsMonitoring: UserRequestsMonitoring

) {

    @PostConstruct
    fun init() {
        userRequestsMonitoring.ping()
    }

    @GetMapping
    fun getAllUsers(): List<UserShortResponseDTO> {
        userRequestsMonitoring.increment()
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): UserDetailsResponseDTO {
        userRequestsMonitoring.increment()
        return userService.getUserById(id)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody userDTO: UserRequestDTO): UserDetailsResponseDTO {
        userRequestsMonitoring.increment()
        return userService.createUser(userDTO)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: UUID, @Valid @RequestBody userDTO: UserRequestDTO): UserDetailsResponseDTO {
        userRequestsMonitoring.increment()
        return userService.updateUser(id, userDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID): UserDetailsResponseDTO {
        userRequestsMonitoring.increment()
        return userService.deleteUser(id)
    }

}