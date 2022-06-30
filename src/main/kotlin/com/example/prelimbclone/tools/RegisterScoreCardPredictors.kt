package com.example.prelimbclone.tools

import com.example.prelimbclone.db.inner.repo.RegionRepository
import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.models.Regions
import org.springframework.stereotype.Component
import java.time.Period

@Component
class RegisterScoreCardPredictors(
    private val regionRepository: RegionRepository,
    private val regions: Regions,
) {
    fun regRegionTable(application: Application): Predictor? {
        val code = if (application.getPerson().registeredAddress?.region != null)
            application.getPerson().registeredAddress?.region
        else
            application.getPerson().registeredAddress?.regionName
        val town = application.getPerson().registeredAddress?.town
        val result: Int?

        return if (!code.isNullOrEmpty() && !town.isNullOrEmpty()) {
            result = regionRepository.findResultByRegionCodeContainsAndRegionCityContains(code.lowercase(),
                town.lowercase())?.result
            Predictor("regRegion", result, result)
        } else if (!code.isNullOrEmpty()) {
            result = regionRepository.findResultByRegionCodeContains(code.lowercase())?.result
            Predictor("regRegion", result, result)
        } else null
    }

    fun regRegionCode(application: Application): Predictor? {
        val region = if (application.getPerson().registeredAddress?.region != null)
            application.getPerson().registeredAddress?.region
        else
            application.getPerson().registeredAddress?.regionName
        val town = application.getPerson().registeredAddress?.town
        var predictorValue: Int = -1

        return if (!region.isNullOrEmpty()) {
            regions.mapOfRegions.entries.forEach { (it1, it2) ->
                predictorValue = if (
                    !town.isNullOrEmpty() &&
                    it1.regionCode.toRegex().matches(region) &&
                    it1.regionTown?.toRegex()?.matches(town) == true
                ) it2
                else if (it1.regionCode.toRegex().matches(region))
                    it2
                else -1
            }
            Predictor("regRegion", predictorValue, predictorValue)
        }
        else Predictor("regRegion", predictorValue, predictorValue)
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