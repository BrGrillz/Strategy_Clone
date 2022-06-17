package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.*
import com.example.prelimbclone.top.hardchecks.TK0001_Applicants_LowAge
import com.example.prelimbclone.top.hardchecks.TK013_CurrentEmploymentDuration


class Trials {
    companion object{
        fun execute(application: Application, decision: Decision){
            decision.trials.parallelStream().forEach {
                getTrial(it, decision)
                assignStrategyDetailsTrials(it, application, decision)
                if (decision.creditType == "SC"){
                    hcTable(it, application, decision)
                } else {
                    hcTable(it, application, decision)
                }
            }
        }

        private fun getTrial(trial: Trial, decision: Decision){
            with (trial.name){
                when {
                    contains("TR_CL") -> decision.creditType = "SC"
                    contains("TR_CC") -> decision.creditType = "RD"
                    contains("TR_SS") -> decision.creditType = "SS"
                }
            }
        }

        private fun assignStrategyDetailsTrials(trial: Trial, application: Application, decision: Decision){
            when {
                trial.name == "TR_CL_STND" && decision.isNewClient == true -> {trial.strategyName = "CashStreet New"; trial.strategyFlow = "CASH_STREET_NEW"}
                trial.name == "TR_CL_STND" && decision.isNewClient == false && application.persons?.activeScOffer == 1-> {trial.strategyName = "CashDM Current"; trial.strategyFlow = "CASH_DM_XSELL"}
                trial.name == "TR_CL_STND" && decision.isNewClient == false -> {trial.strategyName = "CashStreet Current"; trial.strategyFlow = "CASH_STREET_EXISTING"}

                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == true -> {trial.strategyName = "Revolving Street New"; trial.strategyFlow = "CARD_STREET_NEW"}
                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == false && application.persons?.activeRdOffer == 1 -> {trial.strategyName = "Revolving DM Current"; trial.strategyFlow = "CARD_DM_XSELL"}
                trial.name == "TR_CC_TW_LG_STND" && decision.isNewClient == false -> {trial.strategyName = "Revolving Street Current"; trial.strategyFlow = "CARD_STREET_EXISTING"}


                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == true -> {trial.strategyName = "Revolving Street New"; trial.strategyFlow = "CARD_STREET_NEW"}
                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == false && application.persons?.activeRdOffer == 1 -> {trial.strategyName = "Revolving DM Current"; trial.strategyFlow = "CARD_DM_XSELL"}
                trial.name == "TR_CC_HOMER_POLZA_STND" && decision.isNewClient == false -> {trial.strategyName = "Revolving Street Current"; trial.strategyFlow = "CARD_STREET_EXISTING"}
            }
        }

        private fun hcTable(trial: Trial, application: Application, decision: Decision){
            trial.hcDetails = HCDetails()

            when {
                true -> {
                    applyHC("TK1 AGELOW 18", TK0001_Applicants_LowAge, trial, application, decision)
                    trial.hcDetails?.lineID = "COMMON_LINE_HCS"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" -> {
                    applyHC("TK13 EMPDUR 3", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    applyHC("TK087 RestrictedRegRegions 17", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    applyHC("TK103 ActDel 0", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    trial.hcDetails?.lineID = "CC_POLZA_HCS"
                }
                trial.name == "TR_CC_TW_LG_STND" -> {
                    applyHC("TK13 EMPDUR 12", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    applyHC("TK087 RestrictedRegRegions 03", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    applyHC("TK103 CB ActDel 10D", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    trial.hcDetails?.lineID = "CC_LG_HCS"
                }
                trial.name == "TR_CL_STND" -> {
                    applyHC("TK13 EMPDUR 3", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    applyHC("TK087 RestrictedRegRegions 4", TK013_CurrentEmploymentDuration ,trial, application, decision)
                    trial.hcDetails?.lineID = "CC_LG_HCS"
                }
            }
        }

        private fun applyHC(hardCheckName: String, hardCheckType: Any, trial: Trial, application: Application, decision: Decision){
            val tmpHardCheck = try {
                hardCheckType::class.java.getMethod(hardCheckName, Application::class.java).invoke(hardCheckType, application)
            } catch (e: NoSuchMethodException){
                hardCheckType::class.java.getMethod(hardCheckName, Application::class.java, Decision::class.java).invoke(hardCheckType, application, decision)
            }
            if (tmpHardCheck is HardCheck){
                trial.hcDetails?.hardCheck?.add(tmpHardCheck)
            }
        }
    }
}