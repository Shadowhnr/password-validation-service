package com.iti.password.validation.endpoints

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.iti.password.validation.application.entities.VerdictResponse
import com.iti.password.validation.mock.PayloadFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class PasswordValidationEndpointTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    @Test
    fun `given a valid payload, the api should return true`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.validPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(response.valid)
                }
    }

    @Test
    fun `given an empty password, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.emptyPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }

    @Test
    fun `given a password without a digit, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.withoutDigitPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }

    @Test
    fun `given a password with only uppercase letters, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.withoutLowerCasePasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }

    @Test
    fun `given a password without special characters, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.withoutSpecialCharacterPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }

    @Test
    fun `given a password with repeated characters, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.withRepeatedCharactersPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }

    @Test
    fun `given a password with spaces, should return false`() {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/passwords")
                        .content(PayloadFactory.withSpacesPasswordPayload())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
                .andReturn().also {
                    val response = objectMapper.readValue(it.response.contentAsString, VerdictResponse::class.java)
                    assert(!response.valid)
                }
    }
}
