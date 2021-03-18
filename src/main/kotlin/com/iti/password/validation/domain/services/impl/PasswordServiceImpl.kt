package com.iti.password.validation.domain.services.impl

import com.iti.password.validation.application.entities.PasswordValidationRequest
import com.iti.password.validation.domain.services.PasswordService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class PasswordServiceImpl : PasswordService {
    override fun validate(request: PasswordValidationRequest) =
            try {
                println("received request to validate a password: $request")
                request.toDomain()
                println("the password $request is valid")
                true
            } catch (_: IllegalArgumentException) {
                println("the password $request is not valid")
                false
            }
}
