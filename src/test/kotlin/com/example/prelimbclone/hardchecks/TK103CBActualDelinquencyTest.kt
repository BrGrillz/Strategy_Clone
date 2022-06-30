package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TK103CBActualDelinquencyTest{

    @Test
    fun execute_withOverdue() {
        // given
        val maxDaysOverdue = 10
        val sumOverdue = 200
        val application = Application(credit = Credit(creditBureau = CreditBureau(creditData = arrayListOf(
            CreditBureauData(creditSumOverdue = 100, creditDayOverdue = 10, creditJoin = 1),
            CreditBureauData(creditSumOverdue = 200, creditDayOverdue = 5, creditJoin = 1),
        ))))

        // when
        val result = TK103_CB_Actual_Delinquency.execute(sumOverdue, maxDaysOverdue, application)

        // then
        Assertions.assertEquals(HardCheck("TK103_CB_Actual_Delinquency$maxDaysOverdue",
            "CBACTDEL",
            "Applicant currently owes at least $sumOverdue RUR past due with dpd at least $maxDaysOverdue"),
            result)
    }

    @Test
    fun execute_withoutOverdue() {
        // given
        val maxDaysOverdue = 20
        val sumOverdue = 1000
        val application = Application(credit = Credit(creditBureau = CreditBureau(creditData = arrayListOf(
            CreditBureauData(creditSumOverdue = 100, creditDayOverdue = 10),
            CreditBureauData(creditSumOverdue = 200, creditDayOverdue = 5),
        ))))


        // when
        val result = TK103_CB_Actual_Delinquency.execute(sumOverdue, maxDaysOverdue, application)

        // then
        Assertions.assertEquals(null, result)
    }
}