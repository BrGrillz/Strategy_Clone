package com.example.prelimbclone.top.trials

import com.example.prelimbclone.hardchecks.TK0001_Applicants_LowAge
import com.example.prelimbclone.hardchecks.TK013_CurrentEmploymentDuration
import com.example.prelimbclone.hardchecks.TK087_RestrictedRegRegions
import com.example.prelimbclone.hardchecks.TK103_CB_Actual_Delinquency
import com.example.prelimbclone.models.*

class HCTable {
    companion object{
        fun execute(trial: Trial, application: Application, decision: Decision){
            TK0001_Applicants_LowAge.execute(application, 18)?.let { trial.hcDetails.hardCheck.add(it) }
            trial.HCLineID += "COMMON_LINE_HCS;"
            when (trial.name) {
                "TR_CC_HOMER_POLZA_STND" -> {
                    TK013_CurrentEmploymentDuration.execute(application, 3)?.let { trial.hcDetails.hardCheck.add(it) } //TK13 EMPDUR 3
                    TK087_RestrictedRegRegions.execute("17", application, decision)?.let { trial.hcDetails.hardCheck.add(it) } //TK087 RestrictedRegRegions 17
                    TK103_CB_Actual_Delinquency.execute(2000, 10, application)?.let { trial.hcDetails.hardCheck.add(it) } //TK103 CB ActDel 10D
                    trial.HCLineID += "CC_POLZA_HCS;"
                }
                "TR_CC_TW_LG_STND" -> {
                    TK013_CurrentEmploymentDuration.execute(application, 12)?.let { trial.hcDetails.hardCheck.add(it) } //TK13 EMPDUR 12
                    TK087_RestrictedRegRegions.execute("03", application, decision)?.let { trial.hcDetails.hardCheck.add(it) } //TK087 RestrictedRegRegions 03
                    TK103_CB_Actual_Delinquency.execute(200, 0, application)?.let { trial.hcDetails.hardCheck.add(it) } //TK103 ActDel 0
                    trial.HCLineID += "CC_LG_HCS;"
                }

                "TR_CL_STND" -> {
                    TK013_CurrentEmploymentDuration.execute(application, 3)?.let { trial.hcDetails.hardCheck.add(it) } //TK13 EMPDUR 3
                    TK087_RestrictedRegRegions.execute("4", application, decision)?.let { trial.hcDetails.hardCheck.add(it) } //TK087 RestrictedRegRegions 4
                    trial.HCLineID += "CC_CL_HCS;"
                }
            }
        }
    }
}