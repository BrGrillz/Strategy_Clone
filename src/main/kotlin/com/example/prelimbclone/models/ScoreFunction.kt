package com.example.prelimbclone.models

data class ScoreFunction(
    var scoreCardName: String,
    var scoreCardNumber: Int? = null,
    var totalSCore: Double = 0.0,
    var predictors: ArrayList<Predictor>? = ArrayList(),

)
