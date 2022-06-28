package com.example.prelimbclone.trials

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MATrialSelectorSCRDTests {

    @Test
    fun execute_PF_CL_STND_noOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CL_STND"))
        val application = Application(persons = arrayListOf(Person(0)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(null, decision.trials.find { it.name == "TR_CL_STND" })
    }

    @Test
    fun execute_PF_CL_STND_activeOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CL_STND"))
        val application = Application(persons = arrayListOf(Person(1)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(Trial(name = "TR_CL_STND", "", ""), decision.trials.find { it.name == "TR_CL_STND" })
    }

    @Test
    fun execute_PF_CC_HOMER_POLZA_noOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CC_HOMER_POLZA"))
        val application = Application(persons = arrayListOf(Person(0)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(null, decision.trials.find { it.name == "TR_CC_HOMER_POLZA_STND" })
    }

    @Test
    fun execute_PF_CC_HOMER_POLZA_activeOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CC_HOMER_POLZA"))
        val application = Application(persons = arrayListOf(Person(1)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(Trial(name = "TR_CC_HOMER_POLZA_STND", "", ""), decision.trials.find { it.name == "TR_CC_HOMER_POLZA_STND" })
    }

    @Test
    fun execute_PF_CC_TW_LG_noOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CC_TW_LG"))
        val application = Application(persons = arrayListOf(Person(0)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(null, decision.trials.find { it.name == "TR_CC_TW_LG_STND" })
    }

    @Test
    fun execute_PF_CC_TW_LG_activeOffer() {
        // given
        val decision = Decision()
        val products = arrayListOf(Products(productFamily = "PF_CC_TW_LG"))
        val application = Application(persons = arrayListOf(Person(1)), salesPoint = SalesPoint(products = products))

        // when
        MATrialSelectorSCRD.execute(application, decision)

        // then
        Assertions.assertEquals(Trial(name = "TR_CC_TW_LG_STND", "", ""), decision.trials.find { it.name == "TR_CC_TW_LG_STND" })
    }
}