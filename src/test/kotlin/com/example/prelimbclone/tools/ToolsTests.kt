package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Person
import com.example.prelimbclone.models.Predictor
import com.example.prelimbclone.models.ScoreFunction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class ToolsTests {

    @Test
    fun calculatePredictor() {
        // given
        val name = "ageYearsReal"
        val scoreFunction = ScoreFunction("")
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = arrayListOf(Person(birth = LocalDate.of(1990,2,20))))

        // when
        val result = Tools.calculatePredictor(name, scoreFunction, application)

        // then
        assertEquals(Predictor("ageYearsReal", 32, value = 32), result)
    }
}