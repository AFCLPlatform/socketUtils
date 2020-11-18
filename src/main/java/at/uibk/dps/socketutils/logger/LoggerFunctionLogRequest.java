package at.uibk.dps.socketutils.logger;

/**
 * The {@link LoggerFunctionLogRequest} is 
 * 
 * @author fedor
 *
 */
public class LoggerFunctionLogRequest extends LoggerRequest {

	protected final int executionId;

	protected LoggerFunctionLogRequest(final int executionId) {
		super(LoggerRequest.RequestType.GET_INVOCATIONS);
		this.executionId = executionId;
	}

	public int getExecutionId() {
		return executionId;
	}
}
