package com.example.prelimbclone.controllers

import com.example.prelimbclone.implementation.DecisionServiceImplementation
import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InitializationController (
    val decisionServiceImplementation: DecisionServiceImplementation,
    ){

    @PostMapping("/api/v1/prelimB")
    fun call(@RequestBody application: Application): Decision?{
        return decisionServiceImplementation.entrypoint(application)
    }
}
