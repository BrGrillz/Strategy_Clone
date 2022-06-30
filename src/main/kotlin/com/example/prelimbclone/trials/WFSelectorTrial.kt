package com.example.prelimbclone.trials

import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial

class WFSelectorTrial {
    companion object{
        fun execute(trial: Trial, decision: Decision){
            decision.creditType = "MS"
            when{
                trial.hcDetails.hardCheck.isNotEmpty() == true -> {
                    trial.wfDetails.decision = "REJECT"
                    trial.WFLineID += "HC_REJECT;"
                    trial.wfDetails.rejectReason = "HC"
                }
                trial.rgDetails.riskGroup == 9 -> {
                    trial.wfDetails.decision = "REJECT"
                    trial.WFLineID += "SCO_REJECT;"
                    trial.wfDetails.rejectReason = "SCO"
                }
                trial.rgDetails.riskGroup == 0 -> {
                    trial.wfDetails.decision = "REJECT"
                    trial.WFLineID += "SCOFR_REJECT;"
                    trial.wfDetails.rejectReason = "SCOFR"
                }
                else -> {
                    trial.wfDetails.decision = "CONTINUE"
                    trial.WFLineID += "ELSE_CONTINUE;"
                }
            }
        }
    }
}