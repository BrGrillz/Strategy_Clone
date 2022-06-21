package com.example.prelimbclone.top.trials

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RGSelectorTest{
    @Test
    fun execute_containsNew_applyCutoff() {
        // given
        val trial = Trial("TR_CL_STND", "", "CASH_STREET_NEW", ScoringDetails(scoreValue = 150.0))

        // when
        RGSelector.execute(trial)

        // then
        assertEquals(0.9561, trial.rgDetails.cutOffValue)
        assertEquals(9, trial.rgDetails.riskGroup)
        assertEquals("REJ_TR_CL_STND_STREET", trial.rgDetails.lineID)
    }
    @Test
    fun execute_withoutNew_applyCutoff() {
        // given
        val trial = Trial("TR_CL_STND", "", "", ScoringDetails(scoreValue = 150.0))

        // when
        RGSelector.execute(trial)

        // then
        assertEquals(0.9423, trial.rgDetails.cutOffValue)
        assertEquals(9, trial.rgDetails.riskGroup)
        assertEquals("REJ_TR_CL_STND_XSELL", trial.rgDetails.lineID)
    }
}