package com.temporal.mastery.moneytransfer.activity.account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountService {

    public void doSomethingV1(final String arg1) {
        log.info("arg1: {}", arg1);
    }

    public void doSomethingV2(final String arg1) {
        log.info("arg2: {}", arg1);
    }

}
