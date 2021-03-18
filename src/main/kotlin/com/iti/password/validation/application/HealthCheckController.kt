package com.iti.password.validation.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @Autowired
    private lateinit var buildProperties: BuildProperties

    @GetMapping("health-check")
    fun healthCheck(): Map<String, Any?> {
        return mapOf(
                "application_name" to buildProperties.name,
                "package_version" to buildProperties.version,
                "build_time" to buildProperties.time
        )
    }
}
