package com.example.prelimbclone.top.trials

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Person
import com.example.prelimbclone.models.Trial
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AssignStrategyDetailsTrialTest{
    @Test
    fun execute_newClient_noActiveOffer() {
        // given
        val decision = Decision(isNewClient = true)
        val trial = Trial("TR_CL_STND", "", "")
        val application = Application(persons = Person(activeScOffer = 0))

        // when
        AssignStrategyDetailsTrial.execute(trial, application, decision)

        // then
        assertEquals("CashStreet New", trial.strategyName)
        assertEquals("CASH_STREET_NEW", trial.strategyFlow)
    }

    @Test
    fun execute_oldClient_noActiveOffer() {
        // given
        val decision = Decision(isNewClient = false)
        val trial = Trial("TR_CL_STND", "", "")
        val application = Application(persons = Person(activeScOffer = 0))

        // when
        AssignStrategyDetailsTrial.execute(trial, application, decision)

        // then
        assertEquals("CashStreet Current", trial.strategyName)
        assertEquals("CASH_STREET_EXISTING", trial.strategyFlow)
    }
    @Test
    fun execute_oldClient_withActiveOffer() {
        // given
        val decision = Decision(isNewClient = false)
        val trial = Trial("TR_CL_STND", "", "")
        val application = Application(persons = Person(activeScOffer = 1))

        // when
        AssignStrategyDetailsTrial.execute(trial, application, decision)

        // then
        assertEquals("CashDM Current", trial.strategyName)
        assertEquals("CASH_DM_XSELL", trial.strategyFlow)
    }
}