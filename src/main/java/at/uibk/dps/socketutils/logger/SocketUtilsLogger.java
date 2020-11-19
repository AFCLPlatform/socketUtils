package at.uibk.dps.socketutils.logger;

import java.math.BigDecimal;
import java.util.List;

import at.uibk.dps.socketutils.entity.Execution;
import at.uibk.dps.socketutils.entity.Invocation;

/**
 * Static method container for the creation of {@link RequestLogger}s.
 * 
 * @author Fedor Smirnov
 *
 */
public final class SocketUtilsLogger {

	/**
	 * Static container.
	 */
	private SocketUtilsLogger() {
	}

	/**
	 * Generates a request for a new execution ID.
	 * 
	 * @return a request for a new execution ID
	 */
	public static RequestLoggerExecutionId generateExecutionIdRequest() {
		return new RequestLoggerExecutionId();
	}

	/**
	 * Generates a request to update the logs of a requested executution
	 * 
	 * @param execution the execution
	 * @return a request to update the logs of a requested executution
	 */
	public static RequestLoggerXLogsUpdate generateRequestUpdateLog(final Execution execution) {
		return new RequestLoggerXLogsUpdate(execution);
	}

	/**
	 * Generates a request to lookup base function logs of a specific execution in the database.
	 *
	 * @param executionId identifier of the workflow execution.
	 * @return a request to lookup base function logs.
	 */
	public static RequestLoggerFunctionLog generateRequestFunctionLog(final int executionId) {
		return new RequestLoggerFunctionLog(executionId);
	}

	/**
	 * Generate a request to write an invocation to the database.
	 *
	 * @param invocation which should be written to tha database.
	 * @param executionId identifier of the workflow execution.
	 * @return a request to write an invocation to the database.
	 */
	public static RequestLoggerInvocationWrite generateRequestInovationWrite(final Invocation invocation,
			final int executionId) {
		return new RequestLoggerInvocationWrite(invocation, executionId);
	}

	/**
	 * Generate a request to lookup the average execution time of a base function.
	 *
	 * @param functionLink resource of the function.
	 * @return a request to lookup average execution time of a base function.
	 */
	public static RequestLoggerFuncXTimeAvg generateRequestFuncXTimeAvg(final String functionLink) {
		return new RequestLoggerFuncXTimeAvg(functionLink);
	}

	/**
	 * Generate the object representing a response of the logger.
	 *
	 * @param executionId identifier of the workflow execution.
	 * @param avgExecutionTime average execution time.
	 * @param invocations of the base functions.
	 * @return response object of the logger.
	 */
	public static ResponseLogger generateResponse(final int executionId, final BigDecimal avgExecutionTime,
			final List<Invocation> invocations) {
		return new ResponseLogger(executionId, avgExecutionTime, invocations);
	}
}
