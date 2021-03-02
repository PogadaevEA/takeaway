package com.home.takeaway.domain.service;

import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheManagerService {

    private final CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames()
                .forEach(this::evictCache);
    }

    public void evictCache(String cacheName) {
        if (!Strings.isNullOrEmpty(cacheName)) {
            cacheManager.getCache(cacheName).clear();
            log.info("Cache evicted: " + cacheName);
        }
    }
}