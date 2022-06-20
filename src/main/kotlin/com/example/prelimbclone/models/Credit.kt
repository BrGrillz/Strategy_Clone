package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Credit (
    val creditAmount: Int? = null,
    val creditTypePreferred: String? = null,
    val debt: Int? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val endDate: LocalDateTime? = null,
    val status: String? = null,
    val typeSp: String? = null,
    val creditBureau: CreditBureau? = null,
    val supplement: Supplement? = null,
)
