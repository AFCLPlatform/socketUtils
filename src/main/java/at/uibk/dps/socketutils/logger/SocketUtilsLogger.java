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
	 * TODO @stefan: Why do we need both parameters? Doesn't the ID already describe
	 * the execution?
	 * 
	 * @param execution the execution
	 * @param the       ID of the execution
	 * @return a request to update the logs of a requested executution
	 */
	public static RequestLoggerXLogsUpdate generateRequestUpdateLog(final Execution execution,
			final int executionId) {
		return new RequestLoggerXLogsUpdate(execution, executionId);
	}

	public static RequestLoggerFunctionLog generateRequestFunctionLog(final int executionId) {
		return new RequestLoggerFunctionLog(executionId);
	}

	public static RequestLoggerInvocationWrite generateRequestInovationWrite(final Invocation invocation,
			final int executionId) {
		return new RequestLoggerInvocationWrite(invocation, executionId);
	}

	public static RequestLoggerFuncXTimeAvg generateRequestFuncXTimeAvg(final String functionLink) {
		return new RequestLoggerFuncXTimeAvg(functionLink);
	}

	public static ResponseLogger generateResponse(final int executionId, final BigDecimal avgExecutionTime,
			final List<Invocation> invocations) {
		return new ResponseLogger(executionId, avgExecutionTime, invocations);
	}
}
