package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.CreditBureauData
import com.example.prelimbclone.models.HardCheck
import java.time.Period

class TK103_CB_Actual_Delinquency {
    companion object{
        fun execute(sumOverdue: Int, maxDaysOverdue: Int, application: Application): HardCheck?{
            return if (application.credit?.creditBureau?.creditData != null ){
                val sumCreditResult = getSumOverdue(application.credit.creditBureau.creditData, application)

                val sumDaysResult = getMaxDaysOverdue(application.credit.creditBureau.creditData, application)

                if(sumCreditResult >= sumOverdue && sumDaysResult >= maxDaysOverdue){
                    HardCheck("TK103_CB_Actual_Delinquency$maxDaysOverdue", "CBACTDEL", "Applicant currently owes at least $sumOverdue RUR past due with dpd at least $maxDaysOverdue")
                } else null
            } else null
        }

        private fun getSumOverdue(creditBureauData: ArrayList<CreditBureauData>, application: Application): Double{
            var result = 0.0
            creditBureauData.forEach {
                if (
                    it.creditJoin != null && it.creditJoin == 1 &&
                    !(it.contractSource != null && it.contractSource == "vki" &&
                            it.creditUpdate != null && application.sysdate != null &&
                            Period.between(it.creditUpdate, application.sysdate.toLocalDate()).months > 24)
                ){
                    result += if (it.creditSumOverdue == null || (it.creditOwner != null && it.creditOwner == 1 && it.creditType != null && it.creditType != 3))
                        0.0
                    else it.creditSumOverdue
                }
            }
            return result
        }

        private fun getMaxDaysOverdue(creditBureauData: ArrayList<CreditBureauData>, application: Application): Int{
            var result = 0
            creditBureauData.forEach {
                if (!(it.contractSource != null && it.contractSource == "vki" &&
                    it.creditUpdate != null && application.sysdate != null &&
                    Period.between(it.creditUpdate, application.sysdate.toLocalDate()).months > 24)){
                    result = if (it.creditDayOverdue == null || (it.creditOwner != null && it.creditOwner == 1 && it.creditType != null && it.creditType != 3))
                        result
                    else if (it.creditDayOverdue > result)
                        it.creditDayOverdue
                    else result
                }
            }
            return result
        }
    }
}