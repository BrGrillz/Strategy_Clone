package com.example.prelimbclone.service

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision

interface DecisionService {

    fun entrypoint(application: Application): Decision?
}