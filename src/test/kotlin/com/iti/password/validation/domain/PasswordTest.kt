package com.iti.password.validation.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class PasswordTest {
    @Test
    fun `Given a valid password, everything should be fine`() {
        assertDoesNotThrow {
            Password("AbTp9!fok")
        }
    }

    @Test
    fun `Given an invalid password, illegal state exception should be thrown`() {
        assertThrows<IllegalArgumentException> {
            Password("AbTp9 !fok")
        }
    }
}
