package com.example.prelimbclone.trials

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WFSelectorTrialTest{
    @Test
    fun execute_HCReject(){
        // given
        val trial = Trial("", "", "", hcDetails = HCDetails("hc"))
        val decision = Decision()

        // when
        WFSelectorTrial.execute(trial, decision)

        // then
        assertEquals("MS", decision.creditType)
        assertEquals("REJECT", trial.wfDetails.decision)
        assertEquals("HC_REJECT;", trial.WFLineID)
        assertEquals("HC", trial.wfDetails.rejectReason)
    }

    @Test
    fun execute_SCOReject(){
        // given
        val trial = Trial("", "", "", rgDetails = RGDetails(riskGroup = 9))
        val decision = Decision()

        // when
        WFSelectorTrial.execute(trial, decision)

        // then
        assertEquals("MS", decision.creditType)
        assertEquals("REJECT", trial.wfDetails.decision)
        assertEquals("SCO_REJECT;", trial.WFLineID)
        assertEquals("SCO", trial.wfDetails.rejectReason)
    }

    @Test
    fun execute_SCOFRReject(){
        // given
        val trial = Trial("", "", "", rgDetails = RGDetails(riskGroup = 0))
        val decision = Decision()

        // when
        WFSelectorTrial.execute(trial, decision)

        // then
        assertEquals("MS", decision.creditType)
        assertEquals("REJECT", trial.wfDetails.decision)
        assertEquals("SCOFR_REJECT;", trial.WFLineID)
        assertEquals("SCOFR", trial.wfDetails.rejectReason)
    }

    @Test
    fun execute_Continue(){
        // given
        val trial = Trial("", "", "")
        val decision = Decision()

        // when
        WFSelectorTrial.execute(trial, decision)

        // then
        assertEquals("MS", decision.creditType)
        assertEquals("CONTINUE", trial.wfDetails.decision)
        assertEquals("ELSE_CONTINUE;", trial.WFLineID)
        assertEquals(null, trial.wfDetails.rejectReason)
    }
}