package at.uibk.dps.socketutils.logger;

import at.uibk.dps.socketutils.entity.Invocation;

public class RequestLoggerInvocationWrite extends RequestLogger {

	protected final Invocation invocation;

	protected final int executionId;

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
