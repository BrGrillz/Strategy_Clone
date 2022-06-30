package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ScoringTest {

    @Test
    fun execute_test() {
        // given
        val arrayOfTrials = arrayListOf(Trial("TR_CC_HOMER_POLZA_STND", "", ""))
        val application = Application()
        val decision = Decision(score = Score(score1Function = ScoreFunction("ACQ GM 4 201912", 0), score2Function = ScoreFunction("Application 4 0", 1)), trials = arrayOfTrials)

        // when
        Scoring.execute(application, decision)

        // then
        var flag = true
        decision.trials.forEach {
            if (it.scoringDetails.scoreFunction != decision.score.primaryScoreFunction || it.scoringDetails.scoreValue != decision.score.primaryScore){flag = false}
        }

        assertEquals(17.0, decision.score.primaryScore)
        assertEquals("Application 4 0", decision.score.primaryScoreFunction)
        assertEquals(true, flag)
    }
}