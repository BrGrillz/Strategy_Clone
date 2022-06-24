package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PreviousApplications(
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    val firstDate: LocalDateTime?,
//    val isTwPartnerLimitAvailable: Int?,
//    val approvalData: ApprovalData?,
//    val appArray: ArrayList<AppArray>?,
//    val persons[0]: ArrayList<Person>?,
//    val personContact: ArrayList<PersonContact>?,
)
