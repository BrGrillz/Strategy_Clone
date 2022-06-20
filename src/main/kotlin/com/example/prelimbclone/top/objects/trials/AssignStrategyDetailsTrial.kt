package com.example.prelimbclone.top.objects.trials

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial

class AssignStrategyDetailsTrial {
    companion object {
        fun execute(trial: Trial, application: Application, decision: Decision) {
            when {
                trial.name == "TR_CL_STND" && decision.isNewClient == true -> {
                    trial.strategyName = "CashStreet New"; trial.strategyFlow = "CASH_STREET_NEW"
                }
                trial.name == "TR_CL_STND" && decision.isNewClient == false && application.persons?.activeScOffer == 1 -> {
                    trial.strategyName = "CashDM Current"; trial.strategyFlow = "CASH_DM_XSELL"
                }
                trial.name == "TR_CL_STND" && decision.isNewClient == false -> {
                    trial.strategyName = "CashStreet Current"; trial.strategyFlow = "CASH_STREET_EXISTING"
                }


                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == true -> {
                    trial.strategyName = "Revolving Street New"; trial.strategyFlow = "CARD_STREET_NEW"
                }
                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == false && application.persons?.activeRdOffer == 1 -> {
                    trial.strategyName = "Revolving DM Current"; trial.strategyFlow = "CARD_DM_XSELL"
                }
                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == false -> {
                    trial.strategyName = "Revolving Street Current"; trial.strategyFlow = "CARD_STREET_EXISTING"
                }


                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == true -> {
                    trial.strategyName = "Revolving Street New"; trial.strategyFlow = "CARD_STREET_NEW"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == false && application.persons?.activeRdOffer == 1 -> {
                    trial.strategyName = "Revolving DM Current"; trial.strategyFlow = "CARD_DM_XSELL"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == false -> {
                    trial.strategyName = "Revolving Street Current"; trial.strategyFlow = "CARD_STREET_EXISTING"
                }
            }
        }
    }
}