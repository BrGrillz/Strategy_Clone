package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial
import com.example.prelimbclone.top.templates.MATrialSelectorTemplate
import org.springframework.stereotype.Component


@Component
class MATrialSelectorSCRD(override val application: Application, override var decision: Decision, override var trialsArray: ArrayList<Trial>) : MATrialSelectorTemplate(application, decision, trialsArray) {

    fun execute(){
        line1()
        line2()
        line3()
    }

    private fun line1(){
        if (productFamilyName("PF_CL_STND") && application.person?.activeScOffer == 1) {
            addTrial("TR_CL_STND")
        }
    }

    private fun line2(){
        if (productFamilyName("PF_CC_HOMER_POLZA") && application.person?.activeScOffer == 1) {
            addTrial("TR_CC_HOMER_POLZA_STND")
        }
    }
    private fun line3(){
        if (productFamilyName("PF_CC_TW_LG") && application.person?.activeScOffer == 1) {
            addTrial("TR_CC_TW_LG_STND")
        }
    }
}