package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Credit (
    val creditAmount: Int?,
    val creditType: String?,
    val creditTypePrefered: String?,
    val debt: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val endDate: LocalDateTime?,
    val status: String?,
    val typeSp: String?,
)
