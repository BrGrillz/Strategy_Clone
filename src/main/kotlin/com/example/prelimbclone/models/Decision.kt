package com.example.prelimbclone.models


data class Decision(
    var strategyType: String? = null,
    var strategyName: String? = null,
    var strategyVersion: String? = null,
    var strategyFlow: String? = null,
    var trials: ArrayList<Trial> = ArrayList(),
    var score: ArrayList<ScoreFunction> = ArrayList(),
)
