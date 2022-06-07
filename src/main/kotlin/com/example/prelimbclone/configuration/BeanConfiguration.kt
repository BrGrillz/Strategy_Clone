package com.example.prelimbclone.configuration

import com.example.prelimbclone.models.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun approvalCharacteristics(): ArrayList<ApprovalCharacteristics>{
        return ArrayList()
    }

    @Bean
    fun inputScoreModelReturnInfo(): RegScoreModelReturnInfo{
        return RegScoreModelReturnInfo()
    }
}