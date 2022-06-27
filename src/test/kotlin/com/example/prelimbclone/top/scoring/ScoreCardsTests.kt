package com.example.prelimbclone.top.scoring

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class ScoreCardsTests {
    // given
    private val application = Application(
        sysdate = LocalDateTime.of(2050,3,19,12,43,6),
        persons = arrayListOf(Person(birth = LocalDate.of(2000,2,20), education = "1", registeredAddress = RegisteredAddress("77"))),
        credit = (Credit(creditBureau =  CreditBureau(creditData = arrayListOf(CreditBureauData(1, 300)))))
    )

    @Test
    fun `ACQ GM 4 201912`() {
        // given
        val scoreFunction = ScoreFunction("ACQ GM 4 201912", 0)

        // when
        ScoreCards.`ACQ GM 4 201912`(application, scoreFunction)

        // then
        val arrayOfPredictors = arrayListOf(
            Predictor("ageYearsReal", 50, 50),
            Predictor("education", "1", "1"),
            Predictor("regRegion", 2, 2)
        )
        assertEquals(ScoreFunction("ACQ GM 4 201912",0,92.0, arrayOfPredictors), scoreFunction)
    }

    @Test
    fun `Client GM 4 201908`() {
        // given
        val scoreFunction = ScoreFunction("Client GM 4 201908", 1)

        // when
        ScoreCards.`Client GM 4 201908`(application, scoreFunction)

        // then
        val arrayOfPredictors = arrayListOf(
            Predictor("ageYearsReal", 50, 50),
            Predictor("regRegion", 2, 2),
            Predictor("cbActDel", 300.0, 300.0)
        )
        assertEquals(ScoreFunction("Client GM 4 201908",1,132.0, arrayOfPredictors), scoreFunction)
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
            Predictor("regRegion", 2, 2),
        )
        assertEquals(ScoreFunction("Application 4 0",1,33.0, arrayOfPredictors), scoreFunction)
    }
}