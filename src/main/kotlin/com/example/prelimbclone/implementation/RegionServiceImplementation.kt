package com.example.prelimbclone.implementation

import com.example.prelimbclone.repository.RegionRepository
import com.example.prelimbclone.service.RegionService
import org.springframework.stereotype.Service


@Service
class RegionServiceImplementation(
    private val regionRepository: RegionRepository
): RegionService{

    override fun getResultByCode(regionCode: String): Int? =
        regionRepository.findResultByRegionCodeContains(regionCode.lowercase())

    override fun getResultByCodeAndCity(regionCode: String, regionCity: String): Int? =
        regionRepository.findResultByRegionCodeContainsAndRegionCityContains(regionCode.lowercase(), regionCity.lowercase())

}