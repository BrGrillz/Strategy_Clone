package com.example.prelimbclone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.io.File


@SpringBootApplication
class PrelimBCloneApplication

fun main(args: Array<String>) {
    runApplication<PrelimBCloneApplication>(*args)
}

