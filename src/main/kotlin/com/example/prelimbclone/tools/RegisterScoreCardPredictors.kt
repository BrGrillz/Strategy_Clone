package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.ApprovalCharacteristics


class RegisterScoreCardPredictors {
    companion object {
        fun execute(inputName: String, application: Application): ApprovalCharacteristics {

            return when (inputName) {
                "AGE_YEARS_REAL" ->  ApprovalCharacteristics(value = application.sysdate?.monthValue?.let { application.person?.birth?.monthValue?.minus(it) })


                "EDUCATION" -> ApprovalCharacteristics(value = application.person?.education)

                //Можно сделать разными способами, например обращаться в базу
                "REG_REGION" -> ApprovalCharacteristics(value = 3)

                else -> ApprovalCharacteristics()
            }
        }
    }
}