package com.example.prelimbclone.top.trials

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrialsTests {

    @Test
    fun execute_creditType() {
        // given
        val application = Application()
        val trial = Trial("TR_CL", "", "")
        val decision = Decision(trials = arrayListOf(trial))

        // when
        Trials.execute(application, decision)

        // then
        assertEquals("SC", trial.creditType)
    }
}