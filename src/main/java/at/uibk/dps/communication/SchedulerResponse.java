package at.uibk.dps.communication;


import at.uibk.dps.communication.entity.Statistics;
import com.google.gson.JsonObject;

/**
 * This class is used to define the response from
 * the scheduler module (sent to the AFCLPortal).
 *
 * @author stefanpedratscher
 */
public class SchedulerResponse {

    /**
     * The result of the workflow.
     */
    private JsonObject workflowResult;

    /**
     * The execution identifier of the workflow execution.
     */
    private int executionId;

    /**
     * Statistics for the enactment engine.
     */
    private Statistics enactmentEngineStatistics;

    /**
     * Statistics for the scheduler engine.
     */
    private Statistics schedulerStatistics;

    /**
     * Default constructor for scheduler response.
     *
     * @param workflowResult result of the workflow.
     * @param executionId execution identifier of the workflow execution.
     * @param enactmentEngineStatistics statistics for the enactment engine.
     * @param schedulerStatistics statistics for the scheduler.
     */
    public SchedulerResponse(JsonObject workflowResult, int executionId, Statistics enactmentEngineStatistics, Statistics schedulerStatistics) {
        this.workflowResult = workflowResult;
        this.executionId = executionId;
        this.enactmentEngineStatistics = enactmentEngineStatistics;
        this.schedulerStatistics = schedulerStatistics;
    }

    /** Getter and Setter */

    public JsonObject getWorkflowResult() {
        return workflowResult;
    }

    public void setWorkflowResult(JsonObject workflowResult) {
        this.workflowResult = workflowResult;
    }

    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }

    public Statistics getEnactmentEngineStatistics() {
        return enactmentEngineStatistics;
    }

    public void setEnactmentEngineStatistics(Statistics enactmentEngineStatistics) { this.enactmentEngineStatistics = enactmentEngineStatistics; }

    public Statistics getSchedulerStatistics() { return schedulerStatistics; }

    public void setSchedulerStatistics(Statistics schedulerStatistics) { this.schedulerStatistics = schedulerStatistics; }
}
