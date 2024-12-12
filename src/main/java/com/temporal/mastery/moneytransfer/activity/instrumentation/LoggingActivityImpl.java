package com.temporal.mastery.moneytransfer.activity.instrumentation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingActivityImpl implements LoggingActivity {

    @Override
    public void logV1(String message) {
        log.info("logging from logV1: {}", message);
    }

}
