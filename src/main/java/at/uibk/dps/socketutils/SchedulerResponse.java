package at.uibk.dps.socketutils;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;

/**
 * This class is used to define the response from the scheduler module (sent to
 * the AFCLPortal).
 *
 * @author stefanpedratscher
 */
public class SchedulerResponse {

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
	 * Statistics for the scheduler engine.
	 */
	protected final Statistics schedulerStatistics;

	/**
	 * Default constructor for scheduler response.
	 *
	 * @param workflowResult            result of the workflow.
	 * @param executionId               execution identifier of the workflow
	 *                                  execution.
	 * @param enactmentEngineStatistics statistics for the enactment engine.
	 * @param schedulerStatistics       statistics for the scheduler.
	 */
	public SchedulerResponse(final JsonObject workflowResult, final int executionId,
			final Statistics enactmentEngineStatistics, final Statistics schedulerStatistics) {
		this.workflowResult = workflowResult;
		this.executionId = executionId;
		this.enactmentEngineStatistics = enactmentEngineStatistics;
		this.schedulerStatistics = schedulerStatistics;
	}

	/** Getter and Setter */

	public JsonObject getWorkflowResult() {
		return workflowResult;
	}

	public int getExecutionId() {
		return executionId;
	}

	public Statistics getEnactmentEngineStatistics() {
		return enactmentEngineStatistics;
	}

	public Statistics getSchedulerStatistics() {
		return schedulerStatistics;
	}
}
