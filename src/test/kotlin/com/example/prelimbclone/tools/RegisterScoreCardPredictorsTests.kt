package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Credit
import com.example.prelimbclone.models.CreditBureauData
import com.example.prelimbclone.models.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegisterScoreCardPredictorsTests {

    @Test
    fun ageYearsReal() {
        // given
        val application = Application(sysdate = LocalDateTime.parse("19.03.2021 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            person = Person(birth = LocalDateTime.parse("20.02.1990 00:00:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))))

        // when
        val result = RegisterScoreCardPredictors.ageYearsReal(application)

        // then
        Assertions.assertEquals(31, result)
    }
    @Test
    fun education() {
        // given
        val application = Application(person = Person(education = "2"))

        // when
        val result = RegisterScoreCardPredictors.education(application)

        // then
        Assertions.assertEquals("2", result)
    }
    @Test
    fun regRegion() {
        // given
        val application = Application()

        // when
        val result = RegisterScoreCardPredictors.regRegion(application)

        // then
        Assertions.assertEquals(3, result)
    }
    @Test
    fun `cbActDel no overdue`() {
        // given
        val arrayOfCreditData = arrayListOf(
            CreditBureauData(2, 0),
            CreditBureauData(2, 2),
            CreditBureauData(1, 0),
        )
        val application = Application(credit = Credit(creditData = arrayOfCreditData))

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
        val application = Application(credit = Credit(creditData = arrayOfCreditData))

        // when
        val result = RegisterScoreCardPredictors.cbActDel(application)

        // then
        Assertions.assertEquals(3.0, result)
    }
}