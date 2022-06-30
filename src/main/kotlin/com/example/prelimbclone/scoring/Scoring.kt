package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.ScoringDetails
import org.springframework.stereotype.Component

@Component
class Scoring {
    companion object {
        fun execute(application: Application, decision: Decision) {
            if (decision.score.score1Function != null) ScoreCards.`ACQ GM 4 201912`(application, decision.score.score1Function!!)
            if (decision.score.score2Function != null) ScoreCards.`Application 4 0`(application, decision.score.score2Function!!)
            if (decision.score.score3Function != null) ScoreCards.`Client GM 4 201908`(application, decision.score.score3Function!!)

            decision.score.primaryScore = decision.score.score2Function?.totalSCore!!
            decision.score.primaryScoreFunction = decision.score.score2Function?.scoreCardName!!

//            decision.score.scoreFunction.forEach {
//                when (it.scoreCardName) {
//                    "ACQ GM 4 201912" -> ScoreCards.`ACQ GM 4 201912`(application, it)
//                    "Application 4 0" -> ScoreCards.`Application 4 0`(application, it)
//                    "Client GM 4 201908" -> ScoreCards.`Client GM 4 201908`(application, it)
//                }
//
//                if (it.scoreCardNumber == 0) {
//                    decision.score.primaryScore = it.totalSCore
//                    decision.score.primaryScoreFunction = it.scoreCardName
//                }
//            }
            decision.trials.forEach {
                it.scoringDetails = ScoringDetails(decision.score.primaryScoreFunction, decision.score.primaryScore)
            }
        }
    }
}