package at.uibk.dps.communication;


import at.uibk.dps.communication.entity.Statistics;
import com.google.gson.JsonObject;

/**
 * This class is used to define the response from
 * the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineResponse {

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
     * Default constructor for enactment engine response.
     *
     * @param workflowResult result of the workflow.
     * @param executionId execution identifier of the workflow execution.
     * @param enactmentEngineStatistics statistics for the enactment engine.
     */
    public EnactmentEngineResponse(JsonObject workflowResult, int executionId, Statistics enactmentEngineStatistics) {
        this.workflowResult = workflowResult;
        this.executionId = executionId;
        this.enactmentEngineStatistics = enactmentEngineStatistics;
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

    public void setEnactmentEngineStatistics(Statistics enactmentEngineStatistics) {
        this.enactmentEngineStatistics = enactmentEngineStatistics;
    }
}
