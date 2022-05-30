package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.top.templates.SetStrategyDetailsTemplate
import org.springframework.stereotype.Component

@Component
class SetStrategyDetails (override val application: Application, override var decision: Decision) : SetStrategyDetailsTemplate(application,
    decision) {

    fun launch() {
        line1()
        line2()
        line3()
    }

    private fun line1(){
        if (newClient(true)){
            strategyName("MultiApproval_StreetNew")
        }
    }

    private fun line2(){
        if (newClient(false) && (application.person?.activeScOffer == 1 || application.person?.activeRdOffer == 1)){
            strategyName("MultiApproval_DM Current")
        }
    }

    private fun line3(){
        if (newClient(false)){
            strategyName("MultiApproval_Street Current")
        }
    }

}