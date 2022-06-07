package com.example.prelimbclone.service

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.top.objects.ScoreCards
import com.example.prelimbclone.top.objects.AssignSetScoringDetails
import com.example.prelimbclone.top.objects.MATrialSelectorSCRD
import com.example.prelimbclone.top.objects.SetStrategyDetails
import org.springframework.stereotype.Service

@Service
class DecisionService (){

    fun entrypoint(application: Application): Decision?{
        val decision = Decision()


        SetStrategyDetails.execute(application, decision)
        MATrialSelectorSCRD.execute(application, decision)
        AssignSetScoringDetails.execute(decision)
        ScoreCards.execute(application, decision)

        return decision
    }
}