package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.HardCheck

class TK087_RestrictedRegRegions {
    companion object{
        fun execute(region: String, application: Application, decision: Decision): HardCheck?{
            return if (
                (application.getPerson().contactAddress?.region == region || application.getPerson().registeredAddress?.region == region) &&
                decision.creditType == "SS" &&
                application.salesPoint?.sellerplaceTown == "Грозный" &&
                application.salesPoint.sellerplaceCode in listOf(940001, 940002, 940006)
            ) HardCheck("TK087_RestrictedRegRegions_$region", "CLOCLIREG", "Applicant restricted from a loan due to region $region")
            else null
        }
    }
}