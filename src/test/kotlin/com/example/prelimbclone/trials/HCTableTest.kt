package com.example.prelimbclone.trials

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class HCTableTest{

    @Test
    fun execute_hcHit() {
        // given
        val application = Application(sysdate = LocalDateTime.of(2022,2,20,0,0,0),
            persons = arrayListOf(Person(employment = Employment(LocalDateTime.of(2022,1,20,0,0,0)))))
        val decision = Decision()
        val trial = Trial("TR_CC_HOMER_POLZA_STND", "", "")

        // when
        HCTable.execute(trial, application, decision)

        // then
        assertEquals("TK_EMPDUR_3;",trial.hcDetails.hardCheck)
        assertEquals("COMMON_LINE_HCS;CC_POLZA_HCS;", trial.HCLineID)
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
        assertEquals("",trial.hcDetails.hardCheck)
        assertEquals("COMMON_LINE_HCS;CC_POLZA_HCS;", trial.HCLineID)
    }
}