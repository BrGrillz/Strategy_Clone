package com.example.prelimbclone.top.templates

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial
import org.springframework.beans.factory.annotation.Autowired

abstract class MATrialSelectorTemplate (@Autowired open val application: Application, @Autowired open var decision: Decision, @Autowired open var trialsArray: ArrayList<Trial>){


    fun productFamilyName(productFamily: String): Boolean {
        return (application.salesPoint?.products?.any { it.productFamily == productFamily }) == true
    }

    fun addTrial(trialName: String){
        trialsArray.add(Trial(trialName))
        decision.trials?.add(Trial(trialName))
    }
}