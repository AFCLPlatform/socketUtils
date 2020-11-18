package at.uibk.dps.socketutils.logger;

import at.uibk.dps.socketutils.entity.Execution;

/**
 * Request to update the information about a certain execution.
 * 
 * @author Fedor Smirnov
 *
 */
public class LoggerRequestXLogsUpdate extends LoggerRequest{

	protected final Execution execution;
	
	protected final int executionId;

	/**
	 * Default constructor
	 * 
	 * @param execution the requested execution
	 * @param executionId the ID of the requested Execution
	 */
	protected LoggerRequestXLogsUpdate(final Execution execution,final int executionId) {
		super(LoggerRequest.RequestType.UPDATE_EXECUTION);
		this.execution = execution;
		this.executionId = executionId;
	}

	public Execution getExecution() {
		return execution;
	}

	public int getExecutionId() {
		return executionId;
	}
}
