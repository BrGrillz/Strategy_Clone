package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Credit (
    val creditAmount: Int? = null,
    val creditType: String? = null,
    val creditTypePrefered: String? = null,
    val debt: Int? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val endDate: LocalDateTime? = null,
    val status: String? = null,
    val typeSp: String? = null,
    val creditData: ArrayList<CreditBureauData>? = ArrayList(),
)
