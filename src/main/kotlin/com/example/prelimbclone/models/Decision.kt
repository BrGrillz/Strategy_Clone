package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import java.time.Period


data class Decision(
    var strategyType: String? = null,
    var strategyName: String? = null,
    var strategyVersion: String? = null,
    var strategyVersionDate: LocalDateTime = LocalDateTime.now(),
    var strategyFlow: String? = null,
    var trials: ArrayList<Trial> = ArrayList(),
    var score: Score = Score(),
    var creditType: String? = null,
    var workflowCode: String? = null,
    var workflowLineID: String? = null,
    var rejectReason: String? = null,
    var finalRiskGroup: Int? = null,
    @JsonIgnore
    val application: Application? = null,
    @JsonIgnore
    val isNewClient: Boolean? = (application?.applicantData?.previousApplications?.firstDate == null ||
            (application.getPerson().birth != null && application.sysdate != null && Period.between(application.getPerson().birth, application.sysdate.toLocalDate()).months < 1))
)
