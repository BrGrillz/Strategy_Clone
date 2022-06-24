package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime


data class ApplicantData(
    val creditAmountPrefered: Int? = null,
    val creditTypePrefered: String? = null,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    val time: LocalDateTime? = null,
    val maxValueRd: Int? = null,
    val maxValueSc: Int? = null,
    val typeProcess: String? = null,
    val cuid: Int? = null,
    val previousApplications: PreviousApplications? = null,
    val cars: ArrayList<Car>? = null,
)
