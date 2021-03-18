package com.iti.password.validation.domain.services

import com.iti.password.validation.application.entities.PasswordValidationRequest
import com.iti.password.validation.domain.services.impl.PasswordServiceImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PasswordServiceTest {

    @Test
    fun `Given a valid password, should return true`() {
        val password = PasswordValidationRequest("AbTp9!fok")
        val passwordService = PasswordServiceImpl()

        assertEquals(
                true,
                passwordService.validate(password)
        )
    }

    @Test
    fun `Given an invalid password, should return false`() {
        val password = PasswordValidationRequest("AbTp9 fok")
        val passwordService = PasswordServiceImpl()

        assertEquals(
                false,
                passwordService.validate(password)
        )
    }
}
