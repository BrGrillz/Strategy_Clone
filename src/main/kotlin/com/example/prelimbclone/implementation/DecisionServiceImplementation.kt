package com.example.prelimbclone.implementation

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.objects.SetStrategyDetails
import com.example.prelimbclone.objects.WFSelectorUnion
import com.example.prelimbclone.scoring.AssignSetScoringDetails
import com.example.prelimbclone.scoring.Scoring
import com.example.prelimbclone.service.DecisionService
import com.example.prelimbclone.trials.MATrialSelectorSCRD
import com.example.prelimbclone.trials.Trials
import org.springframework.stereotype.Service

@Service
class DecisionServiceImplementation (private val scoring: Scoring): DecisionService{

    override fun entrypoint(application: Application): Decision?{
        val decision = Decision(application = application)


        SetStrategyDetails.execute(application, decision)
        MATrialSelectorSCRD.execute(application, decision)
        AssignSetScoringDetails.execute(decision)
        scoring.execute(application, decision)
        Trials.execute(application, decision)
        WFSelectorUnion.execute(decision)

        return decision
    }
}