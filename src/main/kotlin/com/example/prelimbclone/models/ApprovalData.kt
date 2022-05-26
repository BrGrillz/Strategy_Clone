package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ApprovalData(
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApprovalDateCardsStreet: LocalDateTime,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApprovalDateCardsXsell: LocalDateTime,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApprovalDateFullApplication: LocalDateTime,
)
