package at.uibk.dps.socketutils.enactmentengine;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;

/**
 * This class is used to define the response from the enactment engine module
 * (sent to the scheduler or AFCLPortal).
 *
 * @author stefanpedratscher
 */
public class ResponseEnactmentEngine {

	/**
	 * The result of the workflow.
	 */
	protected final JsonObject workflowResult;

	/**
	 * The execution identifier of the workflow execution.
	 */
	protected final int executionId;

	/**
	 * Statistics for the enactment engine.
	 */
	protected final Statistics enactmentEngineStatistics;

	/**
	 * Default constructor for enactment engine response.
	 *
	 * @param workflowResult            result of the workflow.
	 * @param executionId               execution identifier of the workflow
	 *                                  execution.
	 * @param enactmentEngineStatistics statistics for the enactment engine.
	 */
	protected ResponseEnactmentEngine(final JsonObject workflowResult, final int executionId,
			final Statistics enactmentEngineStatistics) {
		this.workflowResult = workflowResult;
		this.executionId = executionId;
		this.enactmentEngineStatistics = enactmentEngineStatistics;
	}

	public JsonObject getWorkflowResult() {
		return workflowResult;
	}

	public int getExecutionId() {
		return executionId;
	}

	public Statistics getEnactmentEngineStatistics() {
		return enactmentEngineStatistics;
	}
}
