package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Score
import com.example.prelimbclone.models.ScoreFunction


class AssignSetScoringDetails {
    companion object {
        fun execute(decision: Decision) {
            decision.score = Score()
            if (decision.strategyFlow?.contains("_NEW") == true) {
                decision.score.score1Function = ScoreFunction("ACQ GM 4 201912", 0)
                decision.score.score2Function = ScoreFunction("Application 4 0", 1)
            } else {
                decision.score.score3Function = ScoreFunction("Client GM 4 201908", 0)
                decision.score.score2Function = ScoreFunction("Application 4 0", 1)
            }
        }
    }
}