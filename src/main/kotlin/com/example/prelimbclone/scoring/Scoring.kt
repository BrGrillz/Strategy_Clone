package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.ScoringDetails
import org.springframework.stereotype.Component

@Component
class Scoring (private val scoreCards: ScoreCards){

    fun execute(application: Application, decision: Decision){
        decision.score.scoreFunction.forEach {
            when (it.scoreCardName) {
                "ACQ GM 4 201912" -> scoreCards.`ACQ GM 4 201912`(application, it)
                "Application 4 0" -> scoreCards.`Application 4 0`(application, it)
                "Client GM 4 201908" -> scoreCards.`Client GM 4 201908`(application, it)
            }

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