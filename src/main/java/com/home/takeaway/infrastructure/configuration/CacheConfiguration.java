package com.home.takeaway.infrastructure.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
public class CacheConfiguration {

    @Value("${server.params.expireAfterWriteDuration}")
    private Long expireAfterWriteDuration;

    @Bean
    public Caffeine coffeineConfig() {
        return Caffeine.newBuilder()
                .expireAfterWrite(expireAfterWriteDuration, TimeUnit.MINUTES);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);

        return caffeineCacheManager;
    }
}
