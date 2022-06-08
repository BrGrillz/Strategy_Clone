package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Score
import com.example.prelimbclone.models.ScoreFunction


class AssignSetScoringDetails {
    companion object {
        fun execute(decision: Decision) {
            decision.score = Score()
            if (decision.strategyFlow?.contains("_NEW") == true) {
                decision.score?.scoreFunction?.add(ScoreFunction("ACQ GM 4 201912", 0))
                decision.score?.scoreFunction?.add(ScoreFunction("Application 4 0", 1))
            } else {
                decision.score?.scoreFunction?.add(ScoreFunction("Client GM 4 201908", 0))
                decision.score?.scoreFunction?.add(ScoreFunction("Application 4 0", 1))
            }
        }
    }
}