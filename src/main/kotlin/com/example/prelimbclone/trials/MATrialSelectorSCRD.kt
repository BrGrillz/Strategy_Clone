package com.example.prelimbclone.trials

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial


class MATrialSelectorSCRD {
    companion object {
        fun execute(application: Application, decision: Decision) {
            if (application.salesPoint?.products?.any { it.productFamily == "PF_CL_STND" } == true && application.getPerson().activeScOffer == 1) {
                decision.trials.add(Trial("TR_CL_STND", "", ""))
            }
            if (application.salesPoint?.products?.any { it.productFamily == "PF_CC_HOMER_POLZA" } == true) {
                decision.trials.add(Trial("TR_CC_HOMER_POLZA_STND","", ""))
            }
            if (application.salesPoint?.products?.any { it.productFamily == "PF_CC_TW_LG" } == true) {
                decision.trials.add(Trial("TR_CC_TW_LG_STND","", ""))
            }
        }
    }
}