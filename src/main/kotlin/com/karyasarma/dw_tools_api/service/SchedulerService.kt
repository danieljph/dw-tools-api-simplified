package com.karyasarma.dw_tools_api.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Service
class SchedulerService
{
    val logger: Logger = LoggerFactory.getLogger(SchedulerService::class.java)

    /**
     * This task will be run every-day at 13:30.
     */
    @Scheduled(cron = "0 30 5 * * *")
    fun scheduleRefreshCacheData()
    {
        logger.info("[scheduleRefreshCacheData] Task scheduleRefreshCacheData is running...")
        logger.info("[scheduleRefreshCacheData] Dummy processing...")
        logger.info("[scheduleRefreshCacheData] Task scheduleRefreshCacheData has done.")
    }
}
