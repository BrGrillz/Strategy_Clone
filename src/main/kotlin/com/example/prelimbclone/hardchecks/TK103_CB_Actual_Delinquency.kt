package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck

class TK103_CB_Actual_Delinquency {
    companion object{
        fun execute(sumOverdue: Int, maxDaysOverdue: Int, application: Application): HardCheck?{
            return if (application.credit?.creditBureau?.creditData != null ){
                val sumCreditResult = application.credit.creditBureau.creditData.sumOf {
                    try {it.creditSumOverdue!!}
                    catch (e: NullPointerException){
                        0
                    }
                }
                val sumDaysResult = application.credit.creditBureau.creditData.sumOf {
                    try {it.creditDayOverdue!!}
                    catch (e: NullPointerException){
                        0
                    }
                }
                if(sumCreditResult >= sumOverdue && sumDaysResult >= maxDaysOverdue){
                    HardCheck("TK103_CB_Actual_Delinquency$maxDaysOverdue", "CBACTDEL", "Applicant currently owes at least $sumOverdue RUR past due with dpd at least $maxDaysOverdue")
                } else null
            } else null
        }
    }
}