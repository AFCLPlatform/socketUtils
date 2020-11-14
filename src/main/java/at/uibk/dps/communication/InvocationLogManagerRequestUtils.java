package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.Execution;
import at.uibk.dps.communication.entity.Invocation;
import at.uibk.dps.communication.entity.LoggerRequestType;

/**
 * This class is used to define the request which will be sent from the mapping
 * annotator, AFCLPortal or enactment engine to the invocation log manager
 * module.
 *
 * @author stefanpedratscher
 */
public final class InvocationLogManagerRequestUtils {

	/**
	 * Class is a static method container.
	 */
	private InvocationLogManagerRequestUtils() {
	}

	/**
	 * Return a invocation request to get the execution identifier.
	 */
	public static InvocationLogManagerRequest getCreateExecutionIdRequest() {
		return new InvocationLogManagerRequest(LoggerRequestType.GET_EXECUTION_ID);
	}

	/**
	 * Return a invocation request to get the execution identifier.
	 */
	public static InvocationLogManagerRequest getUpdateExecutionLogsRequest(final Execution execution,
			final int executionId) {
		return new InvocationLogManagerRequest(LoggerRequestType.UPDATE_EXECUTION, execution, executionId);
	}

	/**
	 * Return a invocation request to get the execution identifier.
	 */
	public static InvocationLogManagerRequest getFunctionInvocationLogsRequest(final int executionId) {
		return new InvocationLogManagerRequest(LoggerRequestType.GET_INVOCATIONS, executionId);
	}

	/**
	 * Return a invocation request to insert a function invocation.
	 */
	public static InvocationLogManagerRequest getInsertFunctionInvocationRequest(final Invocation invocation,
			final int executionId) {
		return new InvocationLogManagerRequest(LoggerRequestType.INSERT_INVOCATION, invocation, executionId);
	}

	/**
	 * Return average function execution time.
	 */
	public static InvocationLogManagerRequest getAvgFunctionExecutionTimeRequest(final String functionLink) {
		return new InvocationLogManagerRequest(LoggerRequestType.GET_AVG_EXEC_TIME, functionLink);
	}
}
