package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.ApprovalCharacteristics
import lombok.experimental.UtilityClass
import java.time.LocalDateTime

@UtilityClass
class Tools {
    companion object{
        fun isNewClient(firstDate: LocalDateTime?, sysDate: LocalDateTime?): Boolean {
            return firstDate == null || (sysDate?.monthValue != null && sysDate.monthValue - firstDate.monthValue < 1)
        }

        fun calculateApprovalCharacteristic(name: String, type: String, variation: String?, tmpApprovalCharacteristics: ArrayList<ApprovalCharacteristics>, application: Application): ApprovalCharacteristics?{
            var approvalCharacteristic = tmpApprovalCharacteristics.find { it.name == name && it.type ==type && it.variation == variation }
            if (approvalCharacteristic != null){
                return approvalCharacteristic
            } else {
                when (type) {
                    "hardCheck" -> {}
                    "scoreCardPredictor" -> {
                        approvalCharacteristic = RegisterScoreCardPredictors.execute(name, application)
                        tmpApprovalCharacteristics.add(approvalCharacteristic)
                    }
                    "limitLogicCharacteristic" -> {}
                    else -> {}
                }
            }
            return approvalCharacteristic
        }
    }
}