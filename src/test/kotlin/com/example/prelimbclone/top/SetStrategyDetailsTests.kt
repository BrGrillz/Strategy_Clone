package com.example.prelimbclone.top

import com.example.prelimbclone.models.*
import com.example.prelimbclone.top.objects.SetStrategyDetails
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@SpringBootTest
class SetStrategyDetailsTests {
    private val decision = Decision()

    @Test
    fun execute_withNewClient_noOffers() {
        // given
        val application = Application(person = Person(0, 0), sysdate = LocalDateTime.parse("19.01.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))

        // when
        SetStrategyDetails.execute(application, decision)

        // then
        assertEquals("MultiApproval_StreetNew", decision.strategyName)
        assertEquals("Champion", decision.strategyType)
        assertEquals("01.10.2018", decision.strategyVersion)
        assertEquals("STREET_NEW", decision.strategyFlow)

    }
    @Test
    fun execute_withOldClient_noOffers() {
        // given
        val application = Application(
            person = Person(0, 0),
            sysdate = LocalDateTime.parse("19.03.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            applicantData = ApplicantData(
                previousApplications = PreviousApplications(LocalDateTime.parse("19.01.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
            )
        )

        // when
        SetStrategyDetails.execute(application, decision)

        // then
        assertEquals("MultiApproval_Street Current", decision.strategyName)
        assertEquals("Champion", decision.strategyType)
        assertEquals("01.10.2018", decision.strategyVersion)
        assertEquals("STREET_EXISTING", decision.strategyFlow)
    }
    @Test
    fun execute_withNewClient_activeOffers() {
        // given
        val application = Application(
            person = Person(1, 1),
            sysdate = LocalDateTime.parse("19.01.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            applicantData = ApplicantData(
                previousApplications = PreviousApplications(LocalDateTime.parse("19.01.2021 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
            )
        )

        // when
        SetStrategyDetails.execute(application, decision)

        // then
        assertEquals("MultiApproval_StreetNew", decision.strategyName)
        assertEquals("Champion", decision.strategyType)
        assertEquals("01.10.2018", decision.strategyVersion)
        assertEquals("STREET_NEW", decision.strategyFlow)

    }
    @Test
    fun execute_withOldClient_activeOffers() {
        // given
        val decision = Decision()
        val application = Application(
            person = Person(1, 1),
            sysdate = LocalDateTime.parse("19.03.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            applicantData = ApplicantData(
                previousApplications = PreviousApplications(LocalDateTime.parse("19.01.2021 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
            )
        )

        // when
        SetStrategyDetails.execute(application, decision)

        // then
        assertEquals("MultiApproval_DM Current", decision.strategyName)
        assertEquals("Champion", decision.strategyType)
        assertEquals("01.10.2018", decision.strategyVersion)
        assertEquals("XSELL", decision.strategyFlow)

    }
}
