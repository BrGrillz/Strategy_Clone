package com.example.prelimbclone.controllers

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.top.objects.MATrialSelectorSCRD
import com.example.prelimbclone.top.objects.SetStrategyDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InitializationController (@Autowired val setStrategyDetails: SetStrategyDetails,
                                @Autowired val maTrialSelectorSCRD: MATrialSelectorSCRD,
                                var application: Application, var decision: Decision){

    @PostMapping("/api/v1/prelimB")
    fun call(@RequestBody application: Application): Decision?{
        this.application = application

        setStrategyDetails.execute()
        maTrialSelectorSCRD.execute()

        return decision
    }
}
