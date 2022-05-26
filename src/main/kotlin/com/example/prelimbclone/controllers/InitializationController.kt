package com.example.prelimbclone.controllers

import com.example.prelimbclone.models.ObjectModels
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InitializationController {

    @PostMapping("/api/v1/")
    fun call(@RequestBody objectModels: ObjectModels): ObjectModels {
        println(objectModels.applicantData?.cuid == null)
        return objectModels
    }
}