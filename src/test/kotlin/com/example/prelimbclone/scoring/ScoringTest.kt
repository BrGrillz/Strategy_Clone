package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ScoringTest (private val scoring: Scoring){

    @Test
    fun execute_test() {
        // given
        val arrayOfScoreFunctions = arrayListOf(
            ScoreFunction("ACQ GM 4 201912", 0),
            ScoreFunction("Application 4 0", 1)
        )
        val arrayOfTrials = arrayListOf(Trial("TR_CC_HOMER_POLZA_STND", "", ""))
        val application = Application()
        val decision = Decision(score = Score(scoreFunction = arrayOfScoreFunctions), trials = arrayOfTrials)

        // when
        scoring.execute(application, decision)

        // then
        var flag = true
        decision.trials.forEach {
            if (it.scoringDetails.scoreFunction != decision.score.primaryScoreFunction || it.scoringDetails.scoreValue != decision.score.primaryScore){flag = false}
        }

        assertEquals(63.0, decision.score.primaryScore)
        assertEquals("ACQ GM 4 201912", decision.score.primaryScoreFunction)
        assertEquals(true, flag)
    }
}