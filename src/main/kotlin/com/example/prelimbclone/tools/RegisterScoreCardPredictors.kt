package com.example.prelimbclone.tools

import com.example.prelimbclone.db.inner.repo.RegionRepository
import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.models.Region
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
            result = regionRepository.findResultByRegionCodeContainsAndRegionCityContains(code.lowercase(), town.lowercase())?.result
            Predictor("regRegion", result, result)
        }
        else if (!code.isNullOrEmpty()) {
            result = regionRepository.findResultByRegionCodeContains(code.lowercase())?.result
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
        fun regRegion(application: Application): Predictor? {
            val region = if (application.getPerson().registeredAddress?.region != null)
                application.getPerson().registeredAddress?.region
            else
                application.getPerson().registeredAddress?.regionName
            val town = application.getPerson().registeredAddress?.town
            var predictorValue = 0


            val arrayOfRegions1 = mapOf(
                arrayListOf(
                    Region("52","кировская"),
                    Region("87","чукотский"),
                    Region("77","москва"),
                    Region("50","московская"),
                    Region("39","калининградская"),
                    Region("47","ленинградская"),
                    Region("78","[%санкт%петербург%]"),
                    Region("24","норильск"),
                    Region("51","мурманская"),
                    Region("78","мурманская"),
                ) to 1,
            )
            return if (!region.isNullOrEmpty()) {
                arrayOfRegions1.entries.forEach {
                        (it1, it2) ->
                    if (it1.find {
                            if (!it.regionTown.isNullOrEmpty()){
                                it.regionCode.toRegex().containsMatchIn(region) &&
                                        it.regionTown.toRegex().containsMatchIn(region)
                            } else it.regionCode.toRegex().containsMatchIn(region)
                        } != null)
                        predictorValue = it2
                }
                Predictor("regRegion", predictorValue, predictorValue)
            }
            else null
        }
    }
}