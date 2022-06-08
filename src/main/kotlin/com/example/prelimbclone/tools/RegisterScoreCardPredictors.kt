package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application


class RegisterScoreCardPredictors {
    companion object {
        fun ageYearsReal(application: Application): Int? {
            return application.person?.birth?.year?.let { application.sysdate?.year?.minus(it) }
        }

        fun education(application: Application): String? {
            return application.person?.education
        }

        fun regRegion(application: Application): Int {
            return when (application.person?.registeredAddress){
                "Москва" -> 2
                "Старый Оскол" -> 1
                else -> 3
            }
        }

        fun cbActDel(application: Application): Double {
            var tmpResult = 0.0
            application.credit?.creditData?.forEach {
                if (it.creditJoin != null && it.creditJoin == 1 && it.creditSumOverdue != null && it.creditSumOverdue > 0){
                    tmpResult += it.creditSumOverdue
                }
            }
            return tmpResult
        }
    }
}