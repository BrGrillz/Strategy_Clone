package com.example.prelimbclone.objects

import com.example.prelimbclone.models.Decision

class WFSelectorUnion {
    companion object{
        fun execute(decision: Decision){
            when {
                decision.trials.isEmpty() -> {
                    decision.workflowCode = "REJECT"
                    decision.workflowLineID = "NO_TRIALS_REJECT"
                    decision.rejectReason = "NO_OFFER"
                    decision.finalRiskGroup = 0
                }
                decision.trials.find { it.wfDetails.decision == "CONTINUE" } == null -> {
                    applyReject("HC",decision)
                    applyReject("SCOFR",decision)
                    applyReject("SCO",decision)
                    applyReject("LIMIT",decision)
                }
                else -> {
                    decision.workflowCode = "APPROVE"
                    decision.workflowLineID = "REGULAR_APPROVE"
                    decision.finalRiskGroup = 1
                }
            }
        }
        private fun applyReject(reason: String, decision: Decision){

            if (decision.trials.find { it.wfDetails.rejectReason.equals(reason) } != null){
                decision.workflowCode = "REJECT"
                decision.workflowLineID = "${reason}_REJECT"
                decision.rejectReason = reason
                decision.finalRiskGroup = 0
            }
        }
    }
}