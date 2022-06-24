package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision


class SetStrategyDetails {

    companion object {
        fun execute(application:Application, decision: Decision) {
            if (decision.isNewClient == true) {
                decision.strategyName = "MultiApproval_StreetNew"
                decision.strategyType = "Champion"
                decision.strategyVersion = "01.10.2018"
                decision.strategyFlow = "STREET_NEW"
            } else
                if ((application.persons?.get(0)?.activeScOffer == 1 || application.persons?.get(0)?.activeRdOffer == 1)) {
                    decision.strategyName = "MultiApproval_DM Current"
                    decision.strategyType = "Champion"
                    decision.strategyVersion = "01.10.2018"
                    decision.strategyFlow = "XSELL"
                } else {
                    decision.strategyName = "MultiApproval_Street Current"
                    decision.strategyType = "Champion"
                    decision.strategyVersion = "01.10.2018"
                    decision.strategyFlow = "STREET_EXISTING"
                }
        }
    }
}