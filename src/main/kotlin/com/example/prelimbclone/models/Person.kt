package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime


data class Person(
    val activeScOffer: Int? = null,
    val activeRdOffer: Int? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val birth: LocalDateTime? = null,
    val education: String? = null,
    val registeredAddress: RegisteredAddress? = null,
    val employment: Employment? = null,
    val incomeType: String? = null,
    val contactAddress: ContactAddress? = null,
    ) {


}
