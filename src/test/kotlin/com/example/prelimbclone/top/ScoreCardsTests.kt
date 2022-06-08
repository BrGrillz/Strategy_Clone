package com.example.prelimbclone.top

import com.example.prelimbclone.models.*
import com.example.prelimbclone.top.objects.ScoreCards
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ScoreCardsTests {
    // given
    private val application = Application(
        sysdate = LocalDateTime.parse("19.03.2050 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
        persons = Person(birth = LocalDateTime.parse("20.02.2000 00:00:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")), education = "1", registeredAddress = RegisteredAddress(77)),
        credit = (Credit(creditData = arrayListOf(CreditBureauData(1, 300))))
    )

    @Test
    fun `ACQ GM 4 201912`() {
        // given
        val scoreFunction = ScoreFunction("ACQ_GM_4_201912", 0)

        // when
        ScoreCards.`ACQ GM 4 201912`(application, scoreFunction)

        // then
        val arrayOfPredictors = arrayListOf(
            Predictor("ageYearsReal", 50, 50),
            Predictor("education", "1", "1"),
            Predictor("regRegion", 1, 1)
        )
        assertEquals(ScoreFunction("ACQ_GM_4_201912",0,62.0, arrayOfPredictors), scoreFunction)
    }

    @Test
    fun `Client GM 4 201908`() {
        // given
        val scoreFunction = ScoreFunction("Client_GM_4_201908", 1)

        // when
        ScoreCards.`Client GM 4 201908`(application, scoreFunction)

        // then
        val arrayOfPredictors = arrayListOf(
            Predictor("ageYearsReal", 50, 50),
            Predictor("regRegion", 1, 1),
            Predictor("cbActDel", 300.0, 300.0)
        )
        assertEquals(ScoreFunction("Client_GM_4_201908",1,102.0, arrayOfPredictors), scoreFunction)
    }

    @Test
    fun `Application 4 0`() {
        // given
        val scoreFunction = ScoreFunction("Application 4 0", 1)

        // when
        ScoreCards.`Application 4 0`(application, scoreFunction)

        // then
        val arrayOfPredictors = arrayListOf(
            Predictor("ageYearsReal", 50, 50),
            Predictor("regRegion", 1, 1),
        )
        assertEquals(ScoreFunction("Application 4 0",1,23.0, arrayOfPredictors), scoreFunction)
    }
}