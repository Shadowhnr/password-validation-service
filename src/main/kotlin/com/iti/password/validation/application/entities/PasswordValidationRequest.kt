package com.iti.password.validation.application.entities

import com.iti.password.validation.domain.Password

data class PasswordValidationRequest(
        val password: String
) {
    fun toDomain() = Password(password)
}
