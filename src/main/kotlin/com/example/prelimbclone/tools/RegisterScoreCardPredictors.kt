package com.example.prelimbclone.tools

import com.example.prelimbclone.db.inner.repo.RegionRepository
import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import org.springframework.stereotype.Component
import java.time.Period

@Component
class RegisterScoreCardPredictors(
    private val regionRepository: RegionRepository
) {
    fun regRegion(application: Application): Predictor? {
        val code = if (application.getPerson().registeredAddress?.region != null)
            application.getPerson().registeredAddress?.region
        else
            application.getPerson().registeredAddress?.regionName
        val town = application.getPerson().registeredAddress?.town
        val result: Int?

        return if (!code.isNullOrEmpty() && !town.isNullOrEmpty()) {
            val timeStart = System.nanoTime()
            result = regionRepository.findResultByRegionCodeContainsAndRegionCityContains(code.lowercase(), town.lowercase())?.result
            val timeFinish = System.nanoTime()
            println("db ${timeFinish - timeStart}")
            Predictor("regRegion", result, result)
        }
        else if (!code.isNullOrEmpty()) {
            val timeStart = System.nanoTime()
            result = regionRepository.findResultByRegionCodeContains(code.lowercase())?.result
            val timeFinish = System.nanoTime()
            println("db ${timeFinish - timeStart}")
            Predictor("regRegion", result, result)
        }
        else null
    }
    companion object {

        fun ageYearsReal(application: Application): Int? {
            return if (application.getPerson().birth != null && application.sysdate != null)
                Period.between(application.getPerson().birth, application.sysdate.toLocalDate()).years
            else null
        }

        fun education(application: Application): String? {
            return application.getPerson().education
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