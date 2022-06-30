package com.example.prelimbclone.tools

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class RegisterScoreCardPredictorsTests (){

    @Test
    fun ageYearsReal() {
        // given
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = arrayListOf(Person(birth = LocalDate.of(1990,2,20))))

        // when
        val result = RegisterScoreCardPredictors.ageYearsReal(application)

        // then
        Assertions.assertEquals(32, result)
    }
    @Test
    fun education() {
        // given
        val application = Application(persons = arrayListOf(Person(education = "2")))

        // when
        val result = RegisterScoreCardPredictors.education(application)

        // then
        Assertions.assertEquals("2", result)
    }

    @Test
    fun regRegion_NoRegionCode_NoRegionTown() {
        // given
        val application = Application()

        // when
        val result = RegisterScoreCardPredictors.regRegionCode(application)

        // then
        Assertions.assertEquals(-1, result)
    }

    @Test
    fun regRegion_WithRegionCode_NoRegionTown() {
        // given
        val application = Application(persons = arrayListOf(Person(registeredAddress = RegisteredAddress("77"))))

        // when
        val result = RegisterScoreCardPredictors.regRegionCode(application)

        // then
        Assertions.assertEquals(1, result)
    }

    @Test
    fun regRegion_WithRegionCode_WithRegionTown() {
        // given
        val application = Application(persons = arrayListOf(Person(registeredAddress = RegisteredAddress(regionName = "город красноярский округ", town = "город крсноярск "))))

        // when
        val result = RegisterScoreCardPredictors.regRegionCode(application)

        // then
        Assertions.assertEquals(2, result)
    }

    @Test
    fun `cbActDel no overdue`() {
        // given
        val arrayOfCreditData = arrayListOf(
            CreditBureauData(2, 0),
            CreditBureauData(2, 2),
            CreditBureauData(1, 0),
        )
        val application = Application(credit = Credit(creditBureau = CreditBureau(arrayOfCreditData)))

        // when
        val result = RegisterScoreCardPredictors.cbActDel(application)

        // then
        Assertions.assertEquals(0.0, result)
    }
    @Test
    fun `cbActDel with multiple overdue`() {
        // given
        val arrayOfCreditData = arrayListOf(
            CreditBureauData(1, 3),
            CreditBureauData(2, 0),
            CreditBureauData(2, 2),
            CreditBureauData(1, 0),
        )
        val application = Application(credit = Credit(creditBureau = CreditBureau(arrayOfCreditData)))

        // when
        val result = RegisterScoreCardPredictors.cbActDel(application)

        // then
        Assertions.assertEquals(3.0, result)
    }
}