package com.example.prelimbclone.models

data class Trial(
    val name: String,
    var scoringDetails: ScoringDetails? = null,
    var strategyName: String? = null,
    var strategyFlow: String? = null,
    var hcDetails: HCDetails? = null,
)
