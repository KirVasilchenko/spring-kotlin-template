package com.github.kirvasilchenko.springkotlintemplate.service.impl

import com.github.kirvasilchenko.springkotlintemplate.dto.UserDetailsResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserRequestDTO
import com.github.kirvasilchenko.springkotlintemplate.dto.UserShortResponseDTO
import com.github.kirvasilchenko.springkotlintemplate.exception.UserNotFoundException
import com.github.kirvasilchenko.springkotlintemplate.mapper.UserMapper
import com.github.kirvasilchenko.springkotlintemplate.model.User
import com.github.kirvasilchenko.springkotlintemplate.repository.UserRepository
import com.github.kirvasilchenko.springkotlintemplate.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val mapper: UserMapper
) : UserService {

    override fun getAllUsers(): List<UserShortResponseDTO> {
        return mapper.mapToShort(userRepository.findAll())
    }

    override fun getUserById(id: UUID): UserDetailsResponseDTO {
        return mapper.mapToDetailed(findById(id))
    }

    override fun createUser(userDTO: UserRequestDTO): UserDetailsResponseDTO {
        return saveAndReturn(mapper.mapToModel(userDTO))
    }

    override fun updateUser(id: UUID, userDTO: UserRequestDTO): UserDetailsResponseDTO {
        val existingUser = findById(id)
        return saveAndReturn(mapper.updateWithDto(existingUser, userDTO))
    }

    override fun deleteUser(id: UUID): UserDetailsResponseDTO {
        userRepository.deleteSoftById(id)
        return mapper.mapToDetailed(findById(id))
    }

    private fun findById(id: UUID): User {
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()
    }

    private fun saveAndReturn(user: User): UserDetailsResponseDTO {
        return mapper.mapToDetailed(userRepository.save(user))
    }

}