package com.example.prelimbclone.top.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.HardCheck

class TK087_RestrictedRegRegions {
    companion object{

        fun `TK087 RestrictedRegregions 17`(application: Application, decision: Decision): HardCheck?{
            return `TK087 RestrictedRegRegions Template`("17", application, decision)
        }
        fun `TK087 RestrictedRegregions 03`(application: Application, decision: Decision): HardCheck?{
            return `TK087 RestrictedRegRegions Template`("03", application, decision)
        }
        fun `TK087 RestrictedRegregions 4`(application: Application, decision: Decision): HardCheck?{
            return `TK087 RestrictedRegRegions Template`("4", application, decision)
        }

        private fun `TK087 RestrictedRegRegions Template`(region: String, application: Application, decision: Decision): HardCheck?{
            return if (
                (application.persons?.contactAddress?.region == region || application.persons?.registeredAddress?.region == region) &&
                decision.creditType == "SS" &&
                application.salesPoint?.sellerplaceTown == "Грозный" &&
                application.salesPoint.sellerplaceCode in listOf(940001, 940002, 940006)
            ){
                HardCheck("TK087_RestrictedRegRegions_$region", "CLOCLIREG", "Applicant restricted from a loan due to region $region")
            } else null
        }
    }
}