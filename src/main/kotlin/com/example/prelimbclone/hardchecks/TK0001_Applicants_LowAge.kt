package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import java.time.Period

class TK0001_Applicants_LowAge{
    companion object{
        fun execute(application: Application, age: Int): HardCheck?{
            return if (
                application.getPerson().birth != null &&
                application.sysdate != null &&
                Period.between(application.getPerson().birth, application.sysdate.toLocalDate()).years < age
            ) HardCheck("TK1_AGELOW_$age", "AGELOW", "Applicant age is lower than $age")
            else null
        }
    }
}