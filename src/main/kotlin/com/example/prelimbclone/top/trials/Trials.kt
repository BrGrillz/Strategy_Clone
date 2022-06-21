package com.example.prelimbclone.top.trials

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial


class Trials {
    companion object{
        fun execute(application: Application, decision: Decision){
            decision.trials.forEach {
                getTrial(it)
                AssignStrategyDetailsTrial.execute(it, application, decision)
                HCTable.execute(it, application, decision)
                RGSelector.execute(it)
                WFSelectorTrial.execute(it, decision)
            }
        }

        private fun getTrial(trial: Trial){
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