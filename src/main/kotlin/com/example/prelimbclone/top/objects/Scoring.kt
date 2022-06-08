package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.ScoreFunction
import com.example.prelimbclone.models.ScoringDetails

class Scoring {
    companion object {
        fun execute(application: Application, decision: Decision){

            decision.score?.scoreFunction?.forEach {
                ScoreCards.Companion::class.java.getMethod(it.scoreCardName, Application::class.java, ScoreFunction::class.java).invoke(ScoreCards, application, it)

                if (it.scoreCardNumber == 0){
                    decision.score?.primaryScore = it.totalSCore
                    decision.score?.primaryScoreFunction = it.scoreCardName
                }
            }
            decision.trials.forEach {
                it.scoringDetails = ScoringDetails()
                it.scoringDetails?.scoreFunction = decision.score?.primaryScoreFunction
                it.scoringDetails?.scoreValue = decision.score?.primaryScore
            }
        }
    }
}