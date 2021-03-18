package com.password.validation.application.entities

import com.password.validation.domain.Password

data class PasswordValidationRequest(
        val password: String
) {
    fun toDomain() = Password(password)
}
