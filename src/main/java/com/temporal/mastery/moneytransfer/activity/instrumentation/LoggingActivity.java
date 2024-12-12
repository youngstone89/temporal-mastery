package com.temporal.mastery.moneytransfer.activity.instrumentation;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface LoggingActivity {

    @ActivityMethod
    void logV1(String message);
}
