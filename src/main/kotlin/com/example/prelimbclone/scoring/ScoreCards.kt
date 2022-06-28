package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.models.ScoreFunction
import com.example.prelimbclone.tools.RegisterScoreCardPredictors
import com.example.prelimbclone.tools.Tools.Companion.calculatePredictor
import org.springframework.stereotype.Component

@Component
class ScoreCards (private val registerScoreCardPredictors: RegisterScoreCardPredictors) {

    fun `ACQ GM 4 201912`(application: Application, scoreFunction: ScoreFunction){
        var initialScore = 50.0
        val ageYearsReal = calculatePredictor("ageYearsReal", scoreFunction, application)
        val education = calculatePredictor("education", scoreFunction, application)
        var regRegion: Predictor? = null
        registerScoreCardPredictors.regRegion(application)?.let {
            scoreFunction.predictors?.add(it)
            regRegion = it
        }

        when (ageYearsReal.value){
            in 65..200 -> initialScore += 5
            in 45..65 -> initialScore += 15
            in 18..45 -> initialScore += 25
            else -> initialScore -= 1
        }
        when (education.value){
            "1" -> initialScore += 2
            "3" -> initialScore -= 8
            "2" -> initialScore += 25
            else -> initialScore -= 1
        }
        when (regRegion?.value){
            1 -> initialScore -= 5
            3 -> initialScore += 15
            2 -> initialScore += 25
            else -> initialScore -= 5
        }
        scoreFunction.totalSCore = initialScore
    }

    fun `Client GM 4 201908`(application: Application, scoreFunction: ScoreFunction){
        var initialScore = 100.0
        val ageYearsReal = calculatePredictor("ageYearsReal", scoreFunction, application)
        var regRegion: Predictor? = null
        registerScoreCardPredictors.regRegion(application)?.let {
            scoreFunction.predictors?.add(it)
            regRegion = it
        }
        val cbActDel = calculatePredictor("cbActDel", scoreFunction, application)

        when (ageYearsReal.value){
            65 -> initialScore += 7
            in 45..65 -> initialScore += 10
            in 18..45 -> initialScore += 30
            else -> initialScore -= 2
        }
        when (regRegion?.value){
            1 -> initialScore -= 5
            3 -> initialScore += 15
            2 -> initialScore += 25
            else -> initialScore -= 5
        }
        when (cbActDel.value){
            in 200..1000 -> initialScore -= 100
            in 18..200 -> initialScore += 5
            in 10..18 -> initialScore -= 10
            else -> initialScore -= 3
        }
        scoreFunction.totalSCore = initialScore
    }

    fun `Application 4 0`(application: Application, scoreFunction: ScoreFunction){
        var initialScore = 25.0
        val ageYearsReal = calculatePredictor("ageYearsReal", scoreFunction, application)
        var regRegion: Predictor? = null
        registerScoreCardPredictors.regRegion(application)?.let {
            scoreFunction.predictors?.add(it)
            regRegion = it
        }


        when (ageYearsReal.value){
            in 65..200 -> initialScore += 3
            in 45..65 -> initialScore += 2
            in 18..45 -> initialScore += 11
            else -> initialScore -= 1
        }
        when (regRegion?.value){
            1 -> initialScore -= 4
            3 -> initialScore += 5
            2 -> initialScore += 6
            else -> initialScore -= 7
        }
        scoreFunction.totalSCore = initialScore
    }
}