package com.example.prelimbclone.models

import com.example.prelimbclone.tools.RegisterScoreCardPredictors

data class ScoreFunction(
    var scoreCardName: String? = null,
    var scoreCardNumber: Int? = null,
    var predictors: ArrayList<Predictor>? = ArrayList(),
    var totalSCore: Double? = null,
)
