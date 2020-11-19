package at.uibk.dps.socketutils.logger;

import at.uibk.dps.socketutils.entity.Invocation;

/**
 * Used to write an invocation to the database.
 *
 * @author stefanpedratscher
 */
public class RequestLoggerInvocationWrite extends RequestLogger {

	/**
	 * The invocation of a base function.
	 */
	protected final Invocation invocation;

	/**
	 * The identifier of the workflow execution.
	 */
	protected final int executionId;

	/**
	 * Request an invocation write to the database.
	 *
	 * @param invocation which should be written to the database.
	 * @param executionId identifier of the workflow execution.
	 */
	protected RequestLoggerInvocationWrite(final Invocation invocation, final int executionId) {
		super(RequestLogger.RequestType.INSERT_INVOCATION);
		this.invocation = invocation;
		this.executionId = executionId;
	}

	public Invocation getInvocation() {
		return invocation;
	}

	public int getExecutionId() {
		return executionId;
	}
}
