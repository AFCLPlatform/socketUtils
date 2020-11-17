package at.uibk.dps.communication.logging;

import at.uibk.dps.communication.entity.Invocation;

public class LoggerInvocationWriteRequest extends LoggerRequest {

	protected final Invocation invocation;

	protected final int executionId;

	protected LoggerInvocationWriteRequest(Invocation invocation, int executionId) {
		super(LoggerRequest.RequestType.INSERT_INVOCATION);
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
