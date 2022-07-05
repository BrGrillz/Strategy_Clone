package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Regions
import org.springframework.stereotype.Component
import java.time.Period

@Component
class RegisterScoreCardPredictors {
//    fun regRegionTable(application: Application): Predictor? {
//        val code = if (application.getPerson().registeredAddress?.region != null)
//            application.getPerson().registeredAddress?.region
//        else
//            application.getPerson().registeredAddress?.regionName
//        val town = application.getPerson().registeredAddress?.town
//        val result: Int?
//
//        return if (!code.isNullOrEmpty() && !town.isNullOrEmpty()) {
//            result = regionRepository.findResultByRegionCodeContainsAndRegionCityContains(code.lowercase(),
//                town.lowercase())?.result
//            Predictor("regRegion", result, result)
//        } else if (!code.isNullOrEmpty()) {
//            result = regionRepository.findResultByRegionCodeContains(code.lowercase())?.result
//            Predictor("regRegion", result, result)
//        } else null
//    }
    companion object {

        fun ageYearsReal(application: Application): Int? {
            return if (application.getPerson().birth != null && application.sysdate != null)
                Period.between(application.getPerson().birth, application.sysdate.toLocalDate()).years
            else null
        }

        fun education(application: Application): String? = application.getPerson().education

        fun cbActDel(application: Application): Double {
            var tmpResult = 0.0
            application.credit?.creditBureau?.creditData?.forEach {
                if (it.creditJoin != null && it.creditJoin == 1 && it.creditSumOverdue != null && it.creditSumOverdue > 0){
                    tmpResult += it.creditSumOverdue
                }
            }
            return tmpResult
        }

        fun regRegionCode(application: Application): Int {
            val region = if (application.getPerson().registeredAddress?.region != null)
                application.getPerson().registeredAddress?.region
            else
                application.getPerson().registeredAddress?.regionName
            val town = application.getPerson().registeredAddress?.town
            val regionsMap = Regions()
            var value = -1

            regionsMap.mapOfRegions.entries.forEach { (it1, it2) ->
                value = if (
                    !town.isNullOrEmpty() && !region.isNullOrEmpty() &&
                    it1.regionCode.toRegex().containsMatchIn(region.lowercase()) &&
                    it1.regionTown?.toRegex()?.containsMatchIn(town.lowercase()) == true &&
                    value<it2
                ) it2
                else if (
                    !region.isNullOrEmpty() &&
                    it1.regionCode.toRegex().containsMatchIn(region.lowercase()) &&
                    value<it2
                ) it2
                else value
            }
            return value
        }
    }
}