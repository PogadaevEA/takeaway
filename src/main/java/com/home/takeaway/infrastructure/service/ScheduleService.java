package com.home.takeaway.infrastructure.service;

import com.home.takeaway.domain.service.CacheManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final CacheManagerService cacheManagerService;

    @Scheduled(fixedDelayString = "${server.params.schedule.delays.scheduleEvictAllCache}")
    public void scheduleEvictAllCache() {
        log.info("Start evict all cache");
        cacheManagerService.evictAllCaches();
        log.info("End evict all cache");
    }
}