package com.example.prelimbclone.hardchecks

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.HardCheck
import java.time.Period

class TK0001_Applicants_LowAge{
    companion object{
        fun execute(application: Application, age: Int): HardCheck?{
            return if (
                application.persons?.get(0)?.birth != null &&
                application.sysdate != null &&
                Period.between(application.persons[0].birth, application.sysdate.toLocalDate()).years < age
            ) HardCheck("TK1_AGELOW_$age", "AGELOW", "Applicant age is lower than $age")
            else null
        }
    }
}