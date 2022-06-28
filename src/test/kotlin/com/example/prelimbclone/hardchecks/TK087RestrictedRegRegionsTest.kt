package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TK087RestrictedRegRegionsTest{

    @Test
    fun execute_fromRestrictedRegion() {
        // given
        val region = "77"
        val application = Application(persons = arrayListOf(Person(contactAddress = ContactAddress(region = "77"), registeredAddress = RegisteredAddress(
            region = "03"))), salesPoint = SalesPoint(sellerplaceCode = 940001, sellerplaceTown = "Грозный"))
        val decision = Decision(creditType = "SS")

        // when
        val result = TK087_RestrictedRegRegions.execute(region, application, decision)

        // then
        assertEquals(HardCheck("TK087_RestrictedRegRegions_$region", "CLOCLIREG", "Applicant restricted from a loan due to region $region"), result)
    }

    @Test
    fun execute_fromNormalRegion() {
        // given
        val region = "05"
        val application = Application(persons = arrayListOf(Person(contactAddress = ContactAddress(region = "77"), registeredAddress = RegisteredAddress(
            region = "03"))), salesPoint = SalesPoint(sellerplaceCode = 940001, sellerplaceTown = "Грозный"))
        val decision = Decision(creditType = "SS")

        // when
        val result = TK087_RestrictedRegRegions.execute(region, application, decision)

        // then
        assertEquals(null, result)
    }
}