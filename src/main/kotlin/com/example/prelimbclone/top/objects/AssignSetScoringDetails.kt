package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.ScoreFunction


class AssignSetScoringDetails {
    companion object {
        fun execute(decision: Decision) {
            if (decision.strategyFlow?.contains("_NEW") == true) {
                decision.score.add(ScoreFunction("ACQ_GM_4_201912", 0))
                decision.score.add(ScoreFunction("Application_4_0", 1))
            } else {
                decision.score.add(ScoreFunction("Client_GM_4_201908", 0))
                decision.score.add(ScoreFunction("Application_4_0", 1))
            }
        }
    }
}