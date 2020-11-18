package at.uibk.dps.socketutils.logging;

import at.uibk.dps.socketutils.entity.Execution;
import at.uibk.dps.socketutils.entity.Invocation;

/**
 * Static method container for the creation of {@link LoggerRequest}s.
 * 
 * @author Fedor Smirnov
 *
 */
public final class LoggerRequestUtils {

	/**
	 * Static container.
	 */
	private LoggerRequestUtils() {
	}

	/**
	 * Generates a request for a new execution ID.
	 * 
	 * @return a request for a new execution ID
	 */
	public static LoggerExecutionIdRequest generateExecutionIdRequest() {
		return new LoggerExecutionIdRequest();
	}

	/**
	 * Generates a request to update the logs of a requested executution
	 * 
	 * TODO @stefan: Why do we need both parameters? Doesn't the ID already describe
	 * the execution?
	 * 
	 * @param execution the execution
	 * @param the       ID of the execution
	 * @return a request to update the logs of a requested executution
	 */
	public static LoggerUpdateExecutionLogsRequest generateUpdateLogRequest(final Execution execution,
			final int executionId) {
		return new LoggerUpdateExecutionLogsRequest(execution, executionId);
	}

	public static LoggerFunctionLogRequest generateFunctionLogRequest(final int executionId) {
		return new LoggerFunctionLogRequest(executionId);
	}

	public static LoggerInvocationWriteRequest generateInsertInvocationRequest(final Invocation invocation,
			final int executionId) {
		return new LoggerInvocationWriteRequest(invocation, executionId);
	}

	public static LoggerAvgFunctionExecTimeRequest generateAvgFunctionExecTimeRequest(final String functionLink) {
		return new LoggerAvgFunctionExecTimeRequest(functionLink);
	}
}
