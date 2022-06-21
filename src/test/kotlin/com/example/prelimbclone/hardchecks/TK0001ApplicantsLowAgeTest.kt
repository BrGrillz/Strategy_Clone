package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import com.example.prelimbclone.models.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class TK0001ApplicantsLowAgeTest{
    @Test
    fun execute_lowerAge() {
        // given
        val age = 18
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = Person(birth = LocalDate.of(2010,2,20)))

        // when
        val result = TK0001_Applicants_LowAge.execute(application, age)

        // then
        assertEquals(HardCheck("TK1_AGELOW_$age", "AGELOW", "Applicant age is lower than $age"), result)
    }

    @Test
    fun execute_higherAge() {
        // given
        val age = 18
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = Person(birth = LocalDate.of(2000,2,20)))

        // when
        val result = TK0001_Applicants_LowAge.execute(application, age)

        // then
        assertEquals(null, result)
    }
}