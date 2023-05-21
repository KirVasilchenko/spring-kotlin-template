package com.github.kirvasilchenko.springkotlintemplate.exception

sealed class EntityNotFoundException(open val entity: String = "Entity"): RuntimeException() {
    override val message: String?
        get() = "${this.entity} not found"
}

class UserNotFoundException(override val entity: String = "User"): EntityNotFoundException() {

}