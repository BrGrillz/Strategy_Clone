package com.example.prelimbclone.service

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.tools.Tools
import com.example.prelimbclone.top.objects.*
import org.springframework.stereotype.Service

@Service
class DecisionService {

    fun entrypoint(application: Application): Decision?{
        val decision = Decision()

        Tools.isNewClient(application,decision)

        SetStrategyDetails.execute(application, decision)
        MATrialSelectorSCRD.execute(application, decision)
        AssignSetScoringDetails.execute(decision)
        Scoring.execute(application, decision)


        return decision
    }
}