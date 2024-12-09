// @@@SNIPSTART money-transfer-java-tests
package moneytransfer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.temporal.mastery.moneytransfer.Shared;
import com.temporal.mastery.moneytransfer.activity.account.AccountActivity;
import com.temporal.mastery.moneytransfer.activity.account.AccountActivityImpl;
import com.temporal.mastery.moneytransfer.workflow.transfer.CoreTransactionDetails;
import com.temporal.mastery.moneytransfer.workflow.transfer.MoneyTransferWorkflow;
import com.temporal.mastery.moneytransfer.workflow.transfer.MoneyTransferWorkflowImpl;
import com.temporal.mastery.moneytransfer.workflow.transfer.TransactionDetails;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;

public class MoneyTransferWorkflowTest {

    private TestWorkflowEnvironment testEnv;
    private Worker worker;
    private WorkflowClient workflowClient;

    @BeforeAll
    public void setUp() {
        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker(Shared.MONEY_TRANSFER_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(MoneyTransferWorkflowImpl.class);
        workflowClient = testEnv.getWorkflowClient();
    }

    @AfterAll
    public void tearDown() {
        testEnv.close();
    }

    @Test
    public void testTransfer() {
        AccountActivity activities = mock(AccountActivityImpl.class);
        worker.registerActivitiesImplementations(activities);
        testEnv.start();
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.MONEY_TRANSFER_TASK_QUEUE)
                .build();
        MoneyTransferWorkflow workflow = workflowClient.newWorkflowStub(MoneyTransferWorkflow.class, options);
        TransactionDetails transaction = new CoreTransactionDetails("account1", "account2", "reference1", 10);
        workflow.transfer(transaction);
        verify(activities).withdraw(eq("account1"), eq("reference1"), eq(10));
        // Cannot reliably test deposit as the failure configurations will affect this
    }
}
// @@@SNIPEND
