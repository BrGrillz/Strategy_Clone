package com.example.prelimbclone.models

data class RegScoreModelReturnInfo(
    var scoreModelName: String? = null,
    var score: Float? = null,
    var initialScore: Float? = null,
    var scoredCharacteristics: ArrayList<Predictor>? = null,
)
