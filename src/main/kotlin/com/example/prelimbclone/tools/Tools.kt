package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.ApprovalCharacteristics
import com.example.prelimbclone.models.Decision
import lombok.experimental.UtilityClass
import java.time.LocalDateTime

@UtilityClass
class Tools {
    companion object{
        fun isNewClient(application: Application, decision: Decision){
            val sysDate =  application.sysdate
            val firstDate =  application.applicantData?.previousApplications?.firstDate
            decision.isNewClient = (firstDate == null || (sysDate != null && sysDate.monthValue - firstDate.monthValue < 1))
        }

        fun calculateApprovalCharacteristic(name: String, type: String, variation: String?, arrayOfApprovalCharacteristics: ArrayList<ApprovalCharacteristics>, application: Application): ApprovalCharacteristics{
            var tmpApprovalCharacteristic = arrayOfApprovalCharacteristics.find { it.name == name && it.type ==type && it.variation == variation }
            if (tmpApprovalCharacteristic != null){
                return tmpApprovalCharacteristic
            } else {
                tmpApprovalCharacteristic = ApprovalCharacteristics(name, type, variation)
                when (type) {
                    "hardCheck" -> {}
                    "ScoreCardPredictor" -> {
                        val registerScoreCardPredictors =  RegisterScoreCardPredictors.Companion::class.java.getMethod(name, Application::class.java)
                        tmpApprovalCharacteristic.value = registerScoreCardPredictors.invoke(RegisterScoreCardPredictors, application)
                        arrayOfApprovalCharacteristics.add(tmpApprovalCharacteristic)
                    }
                    "limitLogicCharacteristic" -> {}
                    else -> {}
                }
            }
            return tmpApprovalCharacteristic
        }
    }
}