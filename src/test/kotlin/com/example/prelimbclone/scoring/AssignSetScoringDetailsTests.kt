package com.example.prelimbclone.scoring

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Score
import com.example.prelimbclone.models.ScoreFunction
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
        val score = Score(score1Function = ScoreFunction("ACQ GM 4 201912", 0), score2Function = ScoreFunction("Application 4 0", 1))

        Assertions.assertEquals(score, decision.score)
    }

    @Test
    fun execute_notEqualsNew() {
        // given
        val decision = Decision(strategyFlow = "STREET_EXISTING")

        // when
        AssignSetScoringDetails.execute(decision)

        // then
        val score = Score(score3Function = ScoreFunction("Client GM 4 201908", 0), score2Function = ScoreFunction("Application 4 0", 1))
        Assertions.assertEquals(score, decision.score)
    }
}