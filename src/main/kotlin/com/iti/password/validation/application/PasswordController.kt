package com.iti.password.validation.application

import com.iti.password.validation.application.entities.PasswordValidationRequest
import com.iti.password.validation.application.entities.VerdictResponse
import com.iti.password.validation.domain.services.PasswordService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordController(
        private val passwordService: PasswordService
) {
    @PostMapping("/passwords")
    fun validate(
            @RequestBody request: PasswordValidationRequest
    ) = VerdictResponse(passwordService.validate(request))
}
