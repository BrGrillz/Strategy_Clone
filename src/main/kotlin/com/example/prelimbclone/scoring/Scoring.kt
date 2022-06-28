package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.ScoreFunction
import com.example.prelimbclone.models.ScoringDetails
import org.springframework.stereotype.Component

@Component
class Scoring (private val scoreCards: ScoreCards){

    fun execute(application: Application, decision: Decision){
        decision.score.scoreFunction.forEach {
            ScoreCards::class.java.getMethod(it.scoreCardName, Application::class.java, ScoreFunction::class.java)
                .invoke(scoreCards, application, it)

            if (it.scoreCardNumber == 0){
                decision.score.primaryScore = it.totalSCore
                decision.score.primaryScoreFunction = it.scoreCardName
            }
        }
        decision.trials.forEach {
            it.scoringDetails = ScoringDetails(decision.score.primaryScoreFunction, decision.score.primaryScore)
        }
    }
}