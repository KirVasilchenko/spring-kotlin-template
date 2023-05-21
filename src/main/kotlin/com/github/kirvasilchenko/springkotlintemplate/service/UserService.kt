package com.github.kirvasilchenko.springkotlintemplate.service

import com.github.kirvasilchenko.springkotlintemplate.dto.UserDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserShortResponseDTO
import java.util.UUID


interface UserService {

    fun getAllUsers(): List<UserShortResponseDTO>

    fun getUserById(id: UUID): UserDetailsResponseDTO

    fun createUser(userDTO: UserRequestDTO): UserDetailsResponseDTO

    fun updateUser(id: UUID, userDTO: UserRequestDTO): UserDetailsResponseDTO

    fun deleteUser(id: UUID): UserDetailsResponseDTO

}