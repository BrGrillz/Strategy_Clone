package com.example.prelimbclone.controllers

import com.example.prelimbclone.implementation.DecisionServiceImpl
import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InitializationController (
    val decisionServiceImpl: DecisionServiceImpl,
    ){

    @PostMapping("/api/v1/prelimB")
    fun call(@RequestBody application: Application): Decision?{
        return decisionServiceImpl.entrypoint(application)
    }
}
