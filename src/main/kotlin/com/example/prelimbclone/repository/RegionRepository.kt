package com.example.prelimbclone.repository

import com.example.prelimbclone.domain.Regions
import org.springframework.data.repository.CrudRepository


interface RegionRepository: CrudRepository<Regions, Int> {

    fun findResultByRegionCodeContains(regionCode: String): Int?

    fun findResultByRegionCodeContainsAndRegionCityContains(regionCode: String, regionCity: String): Int?
}