package ru.kpfu.itis.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by evdodima on 13/05/16.
 * 11-402
 */
public class InfoLogger {
    private static Logger log = Logger.getLogger(InfoLogger.class);

    @Before("execution(* ru.kpfu.itis.service.*.*(..))")
    public void logToInfoService(JoinPoint joinPoint) {
        log.info("\n*****" + new Date() + "*****\n"
                + "Started invocation of service method"
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params: \n"
                + Arrays.toString(joinPoint.getArgs())
                + "\n***********************************");
    }
}
