package at.uibk.dps.socketutils.logger;

/**
 * The {@link LoggerRequestFunctionLog} is 
 * 
 * @author fedor
 *
 */
public class LoggerRequestFunctionLog extends LoggerRequest {

	protected final int executionId;

	protected LoggerRequestFunctionLog(final int executionId) {
		super(LoggerRequest.RequestType.GET_INVOCATIONS);
		this.executionId = executionId;
	}

	public int getExecutionId() {
		return executionId;
	}
}
