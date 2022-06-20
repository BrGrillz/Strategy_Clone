package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate


data class Person(
    val activeScOffer: Int? = null,
    val activeRdOffer: Int? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val birth: LocalDate? = null,
    val education: String? = null,
    val registeredAddress: RegisteredAddress? = null,
    val employment: Employment? = null,
    val incomeType: String? = null,
    val contactAddress: ContactAddress? = null,
    ) {


}
