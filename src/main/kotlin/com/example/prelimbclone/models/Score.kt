package com.example.prelimbclone.models

data class Score(
    var primaryScore: Double? = null,
    var primaryScoreFunction: String? = null,
    var scoreFunction: ArrayList<ScoreFunction> = ArrayList(),
)
