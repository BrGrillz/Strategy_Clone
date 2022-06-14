package com.example.prelimbclone.tools

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ToolsTests {

    @Test
    fun isNewClient_whenTrue() {
        // given
        val application = Application(sysdate = LocalDateTime.parse("19.01.2022 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
        val decision = Decision()
        // when
        Tools.isNewClient(application, decision)

        // then
        assertEquals(true, decision.isNewClient)
    }

    @Test
    fun isNewClient_whenFalse() {
        // given
        val firstDate: LocalDateTime = LocalDateTime.parse("19.01.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        val sysdate: LocalDateTime = LocalDateTime.parse("19.03.2021 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        val application = Application(sysdate = sysdate, applicantData = ApplicantData(previousApplications = PreviousApplications(firstDate = firstDate)))
        val decision = Decision()
        // when
        Tools.isNewClient(application, decision)

        // then
        assertEquals(false, decision.isNewClient)
    }
    @Test
    fun calculateApprovalCharacteristic_predictor_notExist() {
        // given
        val name = "ageYearsReal"
        val type = "ScoreCardPredictor"
        val variation = null
        val tmpApprovalCharacteristics = ArrayList<ApprovalCharacteristics>()
        val application = Application(sysdate = LocalDateTime.parse("19.03.2021 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            persons = Person(birth = LocalDateTime.parse("20.02.1990 00:00:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))))

        // when
        val result = Tools.calculateApprovalCharacteristic(name, type, variation, tmpApprovalCharacteristics, application)

        // then
        assertEquals(ApprovalCharacteristics("ageYearsReal", "ScoreCardPredictor", value = 31), result)
    }
    @Test
    fun calculateApprovalCharacteristic_predictor_exist() {
        // given
        val name = "regRegion"
        val type = "ScoreCardPredictor"
        val variation = null
        val tmpApprovalCharacteristics = arrayListOf(
            ApprovalCharacteristics("regRegion","ScoreCardPredictor", null, 1),
            ApprovalCharacteristics("education","ScoreCardPredictor", null, 1),
            ApprovalCharacteristics("ageYearsReal","ScoreCardPredictor", null, 31),
        )
        val application = Application()

        // when
        val result = tmpApprovalCharacteristics
        Tools.calculateApprovalCharacteristic(name, type, variation, tmpApprovalCharacteristics, application)


        // then
        assertEquals(result, tmpApprovalCharacteristics)
    }

}