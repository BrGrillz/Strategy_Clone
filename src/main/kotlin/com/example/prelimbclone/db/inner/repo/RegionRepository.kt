package com.example.prelimbclone.db.inner.repo

import com.example.prelimbclone.db.inner.entity.RegionsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegionRepository: JpaRepository<RegionsEntity, Int> {

    fun findResultByRegionCodeContains(regionCode: String): RegionsEntity?

    fun findResultByRegionCodeContainsAndRegionCityContains(regionCode: String, regionCity: String): RegionsEntity?
}