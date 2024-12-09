// @@@SNIPSTART money-transfer-java-activity-implementation
package com.temporal.mastery.moneytransfer.activity.account;

import io.temporal.activity.Activity;

public class AccountActivityImpl implements AccountActivity {

    private AccountService accountService;

    public AccountActivityImpl() {
        this.accountService = new AccountService();
    }

    // Mock up the withdrawal of an amount of money from the source account
    @Override
    public void withdraw(String accountId, String referenceId, int amount) {
        System.out.printf("\nWithdrawing $%d from account %s.\n[ReferenceId: %s]\n", amount, accountId, referenceId);
        System.out.flush();
        accountService.doSomethingV1("v1");

    }

    @Override
    public void withdrawV2(String accountId, String referenceId, int amount) {
        System.out.printf("\nWithdrawingV2 $%d from account %s.\n[ReferenceId: %s]\n", amount, accountId, referenceId);
        System.out.flush();
        accountService.doSomethingV2("v2");

    }

    // Mock up the deposit of an amount of money from the destination account
    @Override
    public void deposit(String accountId, String referenceId, int amount) {
        boolean activityShouldSucceed = true;

        if (!activityShouldSucceed) {
            System.out.println("Deposit failed");
            System.out.flush();
            throw Activity.wrap(new RuntimeException("Simulated Activity error during deposit of funds"));
        }

        System.out.printf("\nDepositing $%d into account %s.\n[ReferenceId: %s]\n", amount, accountId, referenceId);
        System.out.flush();
    }

    // Mock up a compensation refund to the source account
    @Override
    public void refund(String accountId, String referenceId, int amount) {
        boolean activityShouldSucceed = true;

        if (!activityShouldSucceed) {
            System.out.println("Refund failed");
            System.out.flush();
            throw Activity.wrap(new RuntimeException("Simulated Activity error during refund to source account"));
        }

        System.out.printf("\nRefunding $%d to account %s.\n[ReferenceId: %s]\n", amount, accountId, referenceId);
        System.out.flush();
    }

}
// @@@SNIPEND
