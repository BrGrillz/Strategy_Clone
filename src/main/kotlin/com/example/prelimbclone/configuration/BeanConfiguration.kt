package com.example.prelimbclone.configuration

import com.example.prelimbclone.models.Application
import com.example.prelimbclone.models.Decision
import com.example.prelimbclone.models.Trial
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun decision(): Decision{
        return Decision()
    }

    @Bean
    fun application(): Application{
        return Application()
    }

    @Bean
    fun trials(): ArrayList<Trial>{
        return ArrayList()
    }
}