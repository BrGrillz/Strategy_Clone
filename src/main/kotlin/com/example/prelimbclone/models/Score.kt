package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Score(
    var primaryScore: Double = 0.0,
    var primaryScoreFunction: String = "",
//    var scoreFunction: ArrayList<ScoreFunction> = ArrayList(),
    var score1Function: ScoreFunction? = null,
    var score2Function: ScoreFunction? = null,
    var score3Function: ScoreFunction? = null,
)
