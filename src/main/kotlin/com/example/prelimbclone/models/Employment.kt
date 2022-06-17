package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Employment(
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val employmentFrom: LocalDateTime? = null,
)
