package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class CreditBureauData(
    val creditJoin: Int? = null,
    val creditSumOverdue: Double? = null,
    val contractSource: String? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    val creditUpdate: LocalDate? = null,
    val creditOwner: Int? = null,
    val creditType: Int? = null,
    val creditCurrency: String? = null,
    val creditDayOverdue: Int? = null,
)
