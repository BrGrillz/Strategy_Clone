package com.example.prelimbclone.tools

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ToolsTests {

    @Test
    fun calculatePredictor() {
        // given
        val name = "ageYearsReal"
        val scoreFunction = ScoreFunction()
        val application = Application(sysdate = LocalDateTime.now(),
            persons = Person(birth = LocalDateTime.parse("20.02.1990 00:00:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))))

        // when
        val result = Tools.calculatePredictor(name, scoreFunction, application)

        // then
        assertEquals(Predictor("ageYearsReal", 32, value = 32), result)
    }
}