package com.example.prelimbclone.controllers

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.service.DecisionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InitializationController (val decisionService: DecisionService){

    @PostMapping("/api/v1/prelimB")
    fun call(@RequestBody application: Application): Decision?{
        return decisionService.entrypoint(application)
    }
}
