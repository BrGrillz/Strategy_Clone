package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.tools.Tools


class SetStrategyDetails {

    companion object {
        fun execute(application:Application, decision: Decision) {
            val isNewClient = Tools.isNewClient(application.applicantData?.previousApplications?.firstDate, application.sysdate)
            if (isNewClient) {
                decision.strategyName = "MultiApproval_StreetNew"
                decision.strategyType = "Champion"
                decision.strategyVersion = "01.10.2018"
                decision.strategyFlow = "STREET_NEW"
            } else
                if ((application.persons?.activeScOffer == 1 || application.persons?.activeRdOffer == 1)) {
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