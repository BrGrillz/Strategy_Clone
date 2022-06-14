package com.example.prelimbclone.top.objects

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision


class Trials {
    companion object{
        fun execute(application: Application, decision: Decision){

        }
        fun getTrial(decision: Decision){
            decision.trials.parallelStream()
        }
    }
}