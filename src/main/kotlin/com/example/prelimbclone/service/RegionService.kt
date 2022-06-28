package com.example.prelimbclone.service

interface RegionService {

    fun getResultByCode(regionCode: String): Int?

    fun getResultByCodeAndCity(regionCode: String, regionCity: String): Int?
}