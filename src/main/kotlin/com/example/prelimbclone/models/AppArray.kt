package com.example.prelimbclone.models

import java.time.LocalDateTime

data class AppArray (
    val evidSrv: Int?,
    val credit: Credit?,
    val firstApprovalStart: LocalDateTime?,
    val person: Person?,
    val product: Products?,
    val salesPoint: SalesPoint?,
)