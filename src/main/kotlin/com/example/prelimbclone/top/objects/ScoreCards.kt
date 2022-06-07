package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.*
import com.example.prelimbclone.tools.Tools


class ScoreCards {
    companion object {
        fun execute(application: Application, decision: Decision){
            val tmpApprovalCharacteristics = ArrayList<ApprovalCharacteristics>()
            for (scoreFunction in decision.score){
                when (scoreFunction.scoreCardName){
                    "ACQ_GM_4_201912" -> ACQ_GM_4_201912(tmpApprovalCharacteristics, application, scoreFunction)
                }
            }
        }

        private fun ACQ_GM_4_201912(tmpApprovalCharacteristics: ArrayList<ApprovalCharacteristics>, application: Application, scoreFunction: ScoreFunction?){
            val initialScore = 50.0
            val ageYearsReal = calculatePredictor("AGE_YEARS_REAL", tmpApprovalCharacteristics, application, scoreFunction)
            val education = calculatePredictor("EDUCATION", tmpApprovalCharacteristics, application, scoreFunction)
            val regRegion = calculatePredictor("REG_REGION", tmpApprovalCharacteristics, application, scoreFunction)

            when (ageYearsReal.value){
                in 65..200 -> initialScore + 5
                in 45..65 -> initialScore + 15
                in 18..45 -> initialScore + 25
                else -> initialScore - 1
            }
            when (education.value){
                1 -> initialScore + 2
                3 -> initialScore - 8
                2 -> initialScore + 25
                else -> initialScore - 1
            }
            when (regRegion.value){
                1 -> initialScore - 5
                3 -> initialScore + 15
                2 -> initialScore + 25
                else -> initialScore - 5
            }
            scoreFunction?.totalSCore = initialScore
        }

        private fun calculatePredictor(predictorName: String,
                                       tmpApprovalCharacteristics: ArrayList<ApprovalCharacteristics>,
                                       application: Application,
                                       scoreFunction: ScoreFunction?,
                                       predictorVariation: String? = null): Predictor{

            val approvalCharacteristic = Tools.calculateApprovalCharacteristic(predictorName,  "ScoreCardPredictor", predictorVariation, tmpApprovalCharacteristics, application)
            val predictor = Predictor(approvalCharacteristic?.name, approvalCharacteristic?.value, approvalCharacteristic?.value)
            scoreFunction?.predictors?.add(predictor)
            return predictor
        }
    }
}