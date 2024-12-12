// @@@SNIPSTART money-transfer-java-coreTransactionDetails
package com.temporal.mastery.moneytransfer.workflow.transfer;

import lombok.Getter;

@Getter
public class CoreTransactionDetails implements TransactionDetails {
    private String sourceAccountId;
    private String destinationAccountId;
    private String transactionReferenceId;
    private int amountToTransfer;

    // MARK: Constructor

    public CoreTransactionDetails() {
        // Default constructor is needed for Jackson deserialization
    }

    public CoreTransactionDetails(String sourceAccountId,
            String destinationAccountId,
            String transactionReferenceId,
            int amountToTransfer) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.transactionReferenceId = transactionReferenceId;
        this.amountToTransfer = amountToTransfer;
    }
}
// @@@SNIPEND
