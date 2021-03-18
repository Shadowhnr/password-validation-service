package com.iti.password.validation.application

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SwaggerController {
    @Suppress("SpringMVCViewInspection")
    @GetMapping("/docs")
    fun swaggerRedirect() = "redirect:/swagger-ui/"
}
