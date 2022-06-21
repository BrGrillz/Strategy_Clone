package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WFSelectorUnionTest{
    @Test
    fun execute_noTrials() {
        // given
        val decision = Decision(trials = arrayListOf())

        // when
        WFSelectorUnion.execute(decision)

        // then
        assertEquals("REJECT", decision.workflowCode)
        assertEquals("NO_TRIALS_REJECT", decision.workflowLineID)
        assertEquals("NO_OFFER", decision.rejectReason)
        assertEquals(0, decision.finalRiskGroup)
    }

    @Test
    fun execute_noContinueTrialsScoReject() {
        // given
        val decision = Decision(trials = arrayListOf(
            Trial("","","", wfDetails = WFDetails("REJECT", rejectReason = "HC")),
            Trial("","","", wfDetails = WFDetails("REJECT", rejectReason = "SCOFR")),
            Trial("","","", wfDetails = WFDetails("REJECT", rejectReason = "SCO"))
        ))

        // when
        WFSelectorUnion.execute(decision)

        // then
        assertEquals("REJECT", decision.workflowCode)
        assertEquals("SCO_REJECT", decision.workflowLineID)
        assertEquals("SCO", decision.rejectReason)
        assertEquals(0, decision.finalRiskGroup)
    }

    @Test
    fun execute_withContinueTrials() {
        // given
        val decision = Decision(trials = arrayListOf(
            Trial("","","", wfDetails = WFDetails("CONTINUE")),
            Trial("","","", wfDetails = WFDetails("REJECT", rejectReason = "SCOFR")),
            Trial("","","", wfDetails = WFDetails("REJECT", rejectReason = "SCO"))
        ))

        // when
        WFSelectorUnion.execute(decision)

        // then
        assertEquals("APPROVE", decision.workflowCode)
        assertEquals("REGULAR_APPROVE", decision.workflowLineID)
        assertEquals(null, decision.rejectReason)
        assertEquals(1, decision.finalRiskGroup)
    }
}