package com.example.prelimbclone.top.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import java.time.LocalDate

class TK013_CurrentEmploymentDuration {
    companion object {

        fun `TK EMPDUR 3`(application: Application): HardCheck? {
            return `TK013 CurrentEmploymentDuration Template`(application, 3)
        }

        fun `TK EMPDUR 12`(application: Application): HardCheck? {
            return `TK013 CurrentEmploymentDuration Template`(application, 12)
        }

        private fun `TK013 CurrentEmploymentDuration Template`(application: Application, month: Int): HardCheck?{
            val employmentFrom = application.persons?.employment?.employmentFrom ?: application.credit?.supplement?.employment?.employmentFrom
            return if (employmentFrom != null && employmentFrom.monthValue.minus(LocalDate.now().monthValue) < month && application.persons?.incomeType != "c"  ) {
                HardCheck("TK_EMPDUR_$month", "EMPDUR", "Applicant is not employed more than $month months")
            } else null
        }
    }
}