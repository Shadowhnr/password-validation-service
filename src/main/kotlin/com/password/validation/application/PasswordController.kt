package com.password.validation.application

import com.password.validation.application.entities.PasswordValidationRequest
import com.password.validation.application.entities.VerdictResponse
import com.password.validation.domain.services.PasswordService
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
