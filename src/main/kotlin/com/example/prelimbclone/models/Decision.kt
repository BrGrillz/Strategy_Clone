package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.Period


data class Decision(
    var strategyType: String? = null,
    var strategyName: String? = null,
    var strategyVersion: String? = null,
    var strategyFlow: String? = null,
    var trials: ArrayList<Trial> = ArrayList(),
    var score: Score = Score(),
    var creditType: String? = null,
    @JsonIgnore
    val application: Application? = null,
    @JsonIgnore
    var isNewClient: Boolean? = (application?.applicantData?.previousApplications?.firstDate == null ||
            (application.persons?.birth != null && application.sysdate != null && Period.between(application.persons.birth, application.sysdate.toLocalDate()).months < 1))
)
