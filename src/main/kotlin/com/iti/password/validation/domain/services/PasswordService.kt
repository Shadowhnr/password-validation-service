package com.iti.password.validation.domain.services

import com.iti.password.validation.application.entities.PasswordValidationRequest

interface PasswordService {
    fun validate(request: PasswordValidationRequest): Boolean
}
