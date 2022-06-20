package com.example.prelimbclone.top.objects.trials

import com.example.prelimbclone.models.*
import com.example.prelimbclone.hardchecks.TK0001_Applicants_LowAge
import com.example.prelimbclone.hardchecks.TK013_CurrentEmploymentDuration


class Trials {
    companion object{
        fun execute(application: Application, decision: Decision){
            decision.trials.forEach {
                getTrial(it, decision)
                AssignStrategyDetailsTrial.execute(it, application, decision)
                HCTable.execute(it, application, decision)
                RGSelector.execute(it)
                WFSelectorTrial.execute(it,decision)
            }
        }

        private fun getTrial(trial: Trial, decision: Decision){
            with (trial.name){
                when {
                    contains("TR_CL") -> trial.creditType = "SC"
                    contains("TR_CC") -> trial.creditType = "RD"
                    contains("TR_SS") -> trial.creditType = "SS"
                }
            }
        }
    }
}