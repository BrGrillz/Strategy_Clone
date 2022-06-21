package com.example.prelimbclone.top.trials

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class HCTableTest{

    @Test
    fun execute_hcHit() {
        // given
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = Person(employment = Employment(LocalDateTime.of(2022,1,20,0,0,0))))
        val decision = Decision()
        val trial = Trial("TR_CC_HOMER_POLZA_STND", "", "")

        // when
        HCTable.execute(trial, application, decision)

        // then
        assertEquals(arrayListOf(HardCheck("TK_EMPDUR_3", "EMPDUR", "Applicant is not employed more than 3 months")),trial.hcDetails.hardCheck)
        assertEquals(arrayListOf("COMMON_LINE_HCS", "CC_POLZA_HCS"), trial.hcDetails.lineID)
    }

    @Test
    fun execute_noHcHit() {
        // given
        val application = Application()
        val decision = Decision()
        val trial = Trial("TR_CC_HOMER_POLZA_STND", "", "")

        // when
        HCTable.execute(trial, application, decision)

        // then
        assertEquals(ArrayList<Any>(),trial.hcDetails.hardCheck)
        assertEquals(arrayListOf("COMMON_LINE_HCS", "CC_POLZA_HCS"), trial.hcDetails.lineID)
    }
}