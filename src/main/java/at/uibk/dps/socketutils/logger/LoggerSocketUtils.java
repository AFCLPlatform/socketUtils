package at.uibk.dps.socketutils.logger;

import java.math.BigDecimal;
import java.util.List;

import at.uibk.dps.socketutils.entity.Execution;
import at.uibk.dps.socketutils.entity.Invocation;

/**
 * Static method container for the creation of {@link LoggerRequest}s.
 * 
 * @author Fedor Smirnov
 *
 */
public final class LoggerSocketUtils {

	/**
	 * Static container.
	 */
	private LoggerSocketUtils() {
	}

	/**
	 * Generates a request for a new execution ID.
	 * 
	 * @return a request for a new execution ID
	 */
	public static LoggerRequestExecutionId generateExecutionIdRequest() {
		return new LoggerRequestExecutionId();
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
	public static LoggerRequestXLogsUpdate generateRequestUpdateLog(final Execution execution,
			final int executionId) {
		return new LoggerRequestXLogsUpdate(execution, executionId);
	}

	public static LoggerRequestFunctionLog generateRequestFunctionLog(final int executionId) {
		return new LoggerRequestFunctionLog(executionId);
	}

	public static LoggerRequestInvocationWrite generateRequestInovationWrite(final Invocation invocation,
			final int executionId) {
		return new LoggerRequestInvocationWrite(invocation, executionId);
	}

	public static LoggerRequestFuncXTimeAvg generateRequestFuncXTimeAvg(final String functionLink) {
		return new LoggerRequestFuncXTimeAvg(functionLink);
	}

	public static LoggerResponse generateResponse(final int executionId, final BigDecimal avgExecutionTime,
			final List<Invocation> invocations) {
		return new LoggerResponse(executionId, avgExecutionTime, invocations);
	}
}
