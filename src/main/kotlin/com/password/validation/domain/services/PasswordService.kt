package com.password.validation.domain.services

import com.password.validation.application.entities.PasswordValidationRequest

interface PasswordService {
    fun validate(request: PasswordValidationRequest): Boolean
}
