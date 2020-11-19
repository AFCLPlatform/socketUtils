package at.uibk.dps.socketutils.logger;

import at.uibk.dps.socketutils.entity.Execution;

/**
 * Request to update the information about a certain execution.
 * 
 * @author Fedor Smirnov
 *
 */
public class RequestLoggerXLogsUpdate extends RequestLogger{

	protected final Execution execution;
	
	protected final int executionId;

	/**
	 * Default constructor
	 * 
	 * @param execution the requested execution
	 */
	protected RequestLoggerXLogsUpdate(final Execution execution) {
		super(RequestLogger.RequestType.UPDATE_EXECUTION);
		this.execution = execution;
		this.executionId = execution.getExecutionId();
	}

	public Execution getExecution() {
		return execution;
	}

	public int getExecutionId() {
		return executionId;
	}
}
