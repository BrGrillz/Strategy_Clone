package com.example.prelimbclone.models

data class ScoreFunction(
    var scoreCardName: String? = null,
    var scoreCardNumber: Int? = null,
    var totalSCore: Double? = null,
    var predictors: ArrayList<Predictor>? = ArrayList(),

)
