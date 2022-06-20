package com.example.prelimbclone.models

data class Score(
    var primaryScore: Double = 0.0,
    var primaryScoreFunction: String = "",
    var scoreFunction: ArrayList<ScoreFunction> = ArrayList(),
)
