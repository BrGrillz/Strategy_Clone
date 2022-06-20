package com.example.prelimbclone.models

data class Trial(
    val name: String,
    var strategyName: String,
    var strategyFlow: String,
    var scoringDetails: ScoringDetails = ScoringDetails(),
    val hcDetails: HCDetails = HCDetails(),
    val rgDetails: RGDetails = RGDetails(),
    val wfDetails: WFDetails = WFDetails(),
    var creditType: String? = null,
)
