package com.example.prelimbclone.top.templates

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.tools.Tools
import org.springframework.beans.factory.annotation.Autowired

abstract class SetStrategyDetailsTemplate (@Autowired open val application: Application, @Autowired open var decision: Decision){


    fun creditType(creditType: String): Boolean{
        return application.credit?.creditType == creditType
    }

    fun newClient(newClient: Boolean): Boolean{
        return Tools(application).isNewClient() == newClient
    }

    fun strategyName(strategyName: String){
        decision.strategyName = strategyName
    }

    fun strategyType(strategyType: String){
        decision.strategyType = strategyType
    }

    fun strategyVersion(strategyVersion: String){
        decision.strategyVersion = strategyVersion
    }

    fun strategyFlow(strategyFlow: String){
        decision.strategyVersionDate = strategyFlow
    }

}