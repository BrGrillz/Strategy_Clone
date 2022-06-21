package com.example.prelimbclone.service

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.top.objects.*
import com.example.prelimbclone.top.scoring.AssignSetScoringDetails
import com.example.prelimbclone.top.scoring.Scoring
import com.example.prelimbclone.top.trials.MATrialSelectorSCRD
import com.example.prelimbclone.top.trials.Trials
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
        WFSelectorUnion.execute(decision)

        return decision
    }
}