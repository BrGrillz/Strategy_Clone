package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Employment
import com.example.prelimbclone.models.HardCheck
import com.example.prelimbclone.models.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class TK013CurrentEmploymentDurationTest{

    @Test
    fun execute_employedLessThan() {
        // given
        val month = 10
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = arrayListOf(Person(employment = Employment(LocalDateTime.of(2022,1,20,0,0,0)))))

        // when
        val result = TK013_CurrentEmploymentDuration.execute(application, month)

        // then
        assertEquals(HardCheck("TK_EMPDUR_$month", "EMPDUR", "Applicant is not employed more than $month months"), result)
    }

    @Test
    fun execute_employedMoreThan() {
        // given
        val month = 2
        val application = Application(sysdate = LocalDateTime.of(2022,5,20,0,0,0),
            persons = arrayListOf(Person(employment = Employment(LocalDateTime.of(2022,1,20,0,0,0)))))

        // when
        val result = TK013_CurrentEmploymentDuration.execute(application, month)

        // then
        assertEquals(null, result)
    }
}