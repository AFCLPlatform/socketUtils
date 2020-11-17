package at.uibk.dps.communication.logging;

/**
 * The {@link LoggerFunctionLogRequest} is 
 * 
 * @author fedor
 *
 */
public class LoggerFunctionLogRequest extends LoggerRequest {

	protected final int executionId;

	protected LoggerFunctionLogRequest(int executionId) {
		super(LoggerRequest.RequestType.GET_INVOCATIONS);
		this.executionId = executionId;
	}

	public int getExecutionId() {
		return executionId;
	}
}
