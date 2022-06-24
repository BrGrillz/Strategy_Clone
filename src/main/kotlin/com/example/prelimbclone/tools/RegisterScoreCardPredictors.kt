package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import java.time.LocalDate
import java.time.Period


class RegisterScoreCardPredictors {
    companion object {

        fun ageYearsReal(application: Application): Int? {
            return if (application.persons?.birth != null && application.sysdate != null)
                Period.between(application.persons.birth, application.sysdate.toLocalDate()).years
            else null
        }

        fun education(application: Application): String? {
            return application.persons?.education
        }

        fun regRegion(application: Application): Int {
            return when (application.persons?.registeredAddress?.region){
                "77" -> 2
                "36" -> 1
                else -> 3
            }
        }

        fun cbActDel(application: Application): Double {
            var tmpResult = 0.0
            application.credit?.creditBureau?.creditData?.forEach {
                if (it.creditJoin != null && it.creditJoin == 1 && it.creditSumOverdue != null && it.creditSumOverdue > 0){
                    tmpResult += it.creditSumOverdue
                }
            }
            return tmpResult
        }
    }
}