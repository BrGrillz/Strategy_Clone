package com.example.prelimbclone.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ToolsTests {

    @Test
    fun isNewClient_whenTrue() {
        // given
        val firstDate: LocalDateTime? = null
        val sysdate: LocalDateTime = LocalDateTime.parse("19.01.2022 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))

        // when
        val result = Tools.isNewClient(firstDate, sysdate)

        // then
        assertEquals(true, result)
    }

    @Test
    fun isNewClient_whenFalse() {
        // given
        val firstDate: LocalDateTime = LocalDateTime.parse("19.01.2022 11:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        val sysdate: LocalDateTime = LocalDateTime.parse("19.03.2021 12:43:06", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))

        // when
        val result = Tools.isNewClient(firstDate, sysdate)

        // then
        assertEquals(false, result)
    }
}