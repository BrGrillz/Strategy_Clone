package com.example.prelimbclone.trials

import com.example.prelimbclone.models.Trial

class RGSelector {
    companion object{
        fun execute(trial: Trial){
            trial.rgDetails.riskGroup = 1
            when {
                trial.name == "TR_CL_STND" && trial.strategyFlow.contains("NEW") && trial.scoringDetails.scoreValue/1000 < 0.9561 -> {
                    trial.rgDetails.cutOffValue = 0.9561
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CL_STND_STREET"
                }
                trial.name == "TR_CL_STND" && trial.scoringDetails.scoreValue/1000 < 0.9423 -> {
                    trial.rgDetails.cutOffValue = 0.9423
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CL_STND_XSELL"
                }
                trial.name == "TR_CC_TW_LG_STND" && trial.strategyFlow.contains("NEW") && trial.scoringDetails.scoreValue/1000 < 0.9123 -> {
                    trial.rgDetails.cutOffValue = 0.9123
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CC_TW_LG_STND_STREET"
                }
                trial.name == "TR_CC_TW_LG_STND" && trial.scoringDetails.scoreValue/1000 < 0.9124 -> {
                    trial.rgDetails.cutOffValue = 0.9124
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CC_TW_LG_STND_XSELL"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" && trial.strategyFlow.contains("NEW") && trial.scoringDetails.scoreValue/1000 < 0.9756 -> {
                    trial.rgDetails.cutOffValue = 0.9756
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CC_HOMER_POLZA_STND_STREET"
                }
                trial.name == "TR_CC_HOMER_POLZA_STND" && trial.scoringDetails.scoreValue/1000 < 0.9456 -> {
                    trial.rgDetails.cutOffValue = 0.9456
                    trial.rgDetails.riskGroup = 9
                    trial.rgDetails.lineID = "REJ_TR_CC_HOMER_POLZA_STND_XSELL"
                }
                else -> {
                    trial.rgDetails.cutOffValue = 1.0
                    trial.rgDetails.riskGroup = 99
                    trial.rgDetails.lineID = "ERROR CASE: NO CUTOFF WAS APPLIED"
                }
            }
        }
    }
}