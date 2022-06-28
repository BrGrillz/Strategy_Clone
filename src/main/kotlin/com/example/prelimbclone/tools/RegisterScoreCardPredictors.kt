package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.service.RegionService
import org.springframework.stereotype.Component
import java.time.Period

@Component
class RegisterScoreCardPredictors(
    private val regionService: RegionService
) {
    fun regRegion(application: Application): Predictor? {
        val code = if (application.persons[0].registeredAddress?.region != null)
            application.persons[0].registeredAddress?.region
        else
            application.persons[0].registeredAddress?.regionName
        val town = application.persons[0].registeredAddress?.town
        val result: Int?

        return if (!code.isNullOrEmpty() && !town.isNullOrEmpty()) {
            result = regionService.getResultByCodeAndCity(code, town)
            Predictor("regRegion", result, result)
        }
        else if (!code.isNullOrEmpty()) {
            result = regionService.getResultByCode(code)
            Predictor("regRegion", result, result)
        }
        else null
    }
    companion object {

        fun ageYearsReal(application: Application): Int? {
            return if (application.persons[0].birth != null && application.sysdate != null)
                Period.between(application.persons[0].birth, application.sysdate.toLocalDate()).years
            else null
        }

        fun education(application: Application): String? {
            return application.persons[0].education
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