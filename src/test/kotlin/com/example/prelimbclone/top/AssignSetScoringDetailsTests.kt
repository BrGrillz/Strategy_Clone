package com.example.prelimbclone.top

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Score
import com.example.prelimbclone.models.ScoreFunction
import com.example.prelimbclone.top.objects.AssignSetScoringDetails
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AssignSetScoringDetailsTests {

    @Test
    fun execute_equalsNew() {
        // given
        val decision = Decision(strategyFlow = "STREET_NEW")

        // when
        AssignSetScoringDetails.execute(decision)

        // then
        val scoreArray = arrayListOf(
            ScoreFunction("ACQ_GM_4_201912", 0),
            ScoreFunction("Application_4_0", 1))
        val score = Score(scoreFunction = scoreArray)
        Assertions.assertEquals(score, decision.score)
    }

    @Test
    fun execute_notEqualsNew() {
        // given
        val decision = Decision(strategyFlow = "STREET_EXISTING")

        // when
        AssignSetScoringDetails.execute(decision)

        // then
        val scoreArray = arrayListOf(
            ScoreFunction("Client_GM_4_201908", 0),
            ScoreFunction("Application_4_0", 1)
        )
        val score = Score(scoreFunction = scoreArray)
        Assertions.assertEquals(score, decision.score)
    }
}