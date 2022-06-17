package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.models.ScoreFunction
import lombok.experimental.UtilityClass

@UtilityClass
class Tools {
    companion object{
        fun calculatePredictor(predictorName: String, scoreFunction: ScoreFunction?, application: Application): Predictor {
            val predictorValue = RegisterScoreCardPredictors.Companion::class.java.getMethod(predictorName, Application::class.java).invoke(RegisterScoreCardPredictors, application)
            val predictor = Predictor(predictorName, predictorValue, predictorValue)
            scoreFunction?.predictors?.add(predictor)
            return predictor
        }
    }
}