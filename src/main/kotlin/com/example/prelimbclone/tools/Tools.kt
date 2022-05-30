package com.example.prelimbclone.tools

import com.example.prelimbclone.models.Application
import java.time.LocalDateTime

class Tools (private val application: Application){

    fun isNewClient(): Boolean {
        val diff = getDateDiffInMonth(application.applicantData?.previousApplications?.firstDate, application.sysdate)
        return application.applicantData?.previousApplications?.firstDate != null || (diff != null && diff < 1)

    }

    fun getDateDiffInMonth(beginDate: LocalDateTime?, sysDate: LocalDateTime?): Int? {
        return if (beginDate != null && sysDate != null) {
            beginDate.monthValue - sysDate.monthValue
        } else null
    }
}