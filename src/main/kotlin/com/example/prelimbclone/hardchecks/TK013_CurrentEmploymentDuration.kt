package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import java.time.Period

class TK013_CurrentEmploymentDuration {
    companion object {
        fun execute(application: Application, month: Int): HardCheck?{
            val employmentFrom = application.getPerson().employment?.employmentFrom
            return if (
                employmentFrom != null && application.sysdate != null &&
                Period.between(employmentFrom.toLocalDate(), application.sysdate.toLocalDate()).months < month &&
                application.getPerson().incomeType != "c"
            ) HardCheck("TK_EMPDUR_$month", "EMPDUR", "Applicant is not employed more than $month months")
            else null
        }
    }
}