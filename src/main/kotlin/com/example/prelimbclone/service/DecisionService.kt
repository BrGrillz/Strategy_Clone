package com.example.prelimbclone.service

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.top.objects.*
import com.example.prelimbclone.top.objects.scoring.AssignSetScoringDetails
import com.example.prelimbclone.top.objects.scoring.Scoring
import com.example.prelimbclone.top.objects.trials.MATrialSelectorSCRD
import com.example.prelimbclone.top.objects.trials.Trials
import org.springframework.stereotype.Service

@Service
class DecisionService {

    fun entrypoint(application: Application): Decision?{
        val decision = Decision(application = application)


        SetStrategyDetails.execute(application, decision)
        MATrialSelectorSCRD.execute(application, decision)
        AssignSetScoringDetails.execute(decision)
        Scoring.execute(application, decision)
        Trials.execute(application, decision)

        return decision
    }
}