package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Application(
    val applicantData: ApplicantData? = null,
    val credit: Credit? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    val sysdate: LocalDateTime? = null,
    val persons: ArrayList<Person> = arrayListOf(Person()),
    val trial: ArrayList<Trial> = ArrayList(),
    val salesPoint: SalesPoint? = null,
) {
    fun getPerson() = persons[0]
}

