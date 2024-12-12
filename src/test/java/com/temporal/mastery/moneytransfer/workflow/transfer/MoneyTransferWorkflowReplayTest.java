package com.temporal.mastery.moneytransfer.workflow.transfer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import io.temporal.testing.WorkflowReplayer;

public class MoneyTransferWorkflowReplayTest {
    @Test
    public void testWorkflowReplay() throws IOException {
        // Load the workflow execution history from a JSON file
        String historyPath = "src/test/resources/MoneyTransferWorkflow_events_history.json";
        String historyJson = new String(Files.readAllBytes(Paths.get(historyPath)));

        // Replay the workflow and assert no exceptions are thrown
        assertDoesNotThrow(() -> WorkflowReplayer.replayWorkflowExecution(
                historyJson,
                MoneyTransferWorkflowImpl.class));
    }
}
