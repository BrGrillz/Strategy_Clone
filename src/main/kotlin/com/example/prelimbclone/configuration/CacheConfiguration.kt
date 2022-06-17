package com.example.prelimbclone.configuration

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit


@Configuration
@EnableCaching
class CacheConfiguration {


    @Bean
    fun caffeineConfig(): Caffeine<Any, Any>? {
        return Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES)
    }

    @Bean
    fun cacheManager(@Qualifier("caffeineConfig") caffeine: Caffeine<Any, Any>): CacheManager? {
        val caffeineCacheManager = CaffeineCacheManager()
        caffeineCacheManager.setCaffeine(caffeine)
        return caffeineCacheManager
    }
}