package com.example.prelimbclone.top.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import java.time.LocalDate
import java.time.Period

class TK0001_Applicants_LowAge{
    companion object{

        fun `TK1 AGELOW 18`(application: Application): HardCheck?{
            return `TK0001 Applicants LowAge Template`(application, 18)
        }

        fun `TK1 AGELOW 12`(application: Application): HardCheck?{
            return `TK0001 Applicants LowAge Template`(application, 12)
        }

        private fun `TK0001 Applicants LowAge Template`(application: Application, age: Int): HardCheck?{
            return if (Period.between(application.persons?.birth?.toLocalDate(), LocalDate.now()).years > age-1){
                HardCheck("TK1_AGELOW_$age", "AGELOW", "Applicant age is lower than $age")
            } else null
        }
    }
}