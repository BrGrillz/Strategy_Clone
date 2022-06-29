package com.example.prelimbclone.trials

import com.example.prelimbclone.models.Trial

class RGSelector {
    companion object{
        fun execute(trial: Trial){
            when {
                trial.name == "TR_CL_STND" && trial.strategyFlow.contains("NEW") -> {
                    if (trial.scoringDetails.scoreValue < 0.9561)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9561
                    trial.RGLineID += "REJ_TR_CL_STND_STREET;"
                }
                trial.name == "TR_CL_STND" -> {
                    if (trial.scoringDetails.scoreValue < 0.9423)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9423
                    trial.RGLineID += "REJ_TR_CL_STND_XSELL;"
                }
                trial.name == "TR_CC_TW_LG_STND" && trial.strategyFlow.contains("NEW") -> {
                    if (trial.scoringDetails.scoreValue < 0.9123)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9123
                    trial.RGLineID += "REJ_TR_CC_TW_LG_STND_STREET;"
                }
                trial.name == "TR_CC_TW_LG_STND" -> {
                    if (trial.scoringDetails.scoreValue < 0.9124)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9124
                    trial.RGLineID += "REJ_TR_CC_TW_LG_STND_XSELL;"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" && trial.strategyFlow.contains("NEW") -> {
                    if (trial.scoringDetails.scoreValue < 0.9756)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9756
                    trial.RGLineID += "REJ_TR_CC_HOMER_POLZA_STND_STREET;"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" -> {
                    if (trial.scoringDetails.scoreValue < 0.9456)
                        trial.rgDetails.riskGroup = 9
                    else trial.rgDetails.riskGroup = 1

                    trial.rgDetails.cutOffValue = 0.9456
                    trial.RGLineID += "REJ_TR_CC_HOMER_POLZA_STND_XSELL;"
                }
                else -> {
                    trial.rgDetails.cutOffValue = 1.0
                    trial.rgDetails.riskGroup = 99
                    trial.RGLineID += "ERROR CASE: NO CUTOFF WAS APPLIED;"
                }
            }
        }
    }
}