package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime


data class Decision(
    var strategyType: String? = null,
    var strategyName: String? = null,
    var strategyVersion: String? = null,
    var strategyFlow: String? = null,
    var trials: ArrayList<Trial> = ArrayList(),
    var score: Score? = null,
    val credit: Credit? = null,
    var creditType: String? = null,
    @JsonIgnore
    val previousApplications: PreviousApplications? = null,
    @JsonIgnore
    var isNewClient: Boolean? = (previousApplications?.firstDate == null || (LocalDateTime.now() != null && LocalDateTime.now().monthValue - previousApplications.firstDate.monthValue < 1))
)
