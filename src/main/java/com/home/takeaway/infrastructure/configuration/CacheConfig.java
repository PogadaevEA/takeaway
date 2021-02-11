package com.home.takeaway.infrastructure.configuration;

import com.google.common.collect.ImmutableList;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.home.takeaway.common.Caches.ROLES;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(ImmutableList.of(
                new ConcurrentMapCache(ROLES),
                new ConcurrentMapCache("IMAGES")
        ));

        return simpleCacheManager;
    }
}
