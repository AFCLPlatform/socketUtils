package at.uibk.dps.socketutils.logger;

/**
 * The {@link RequestLoggerFunctionLog} is 
 * 
 * @author fedor
 *
 */
public class RequestLoggerFunctionLog extends RequestLogger {

	protected final int executionId;

	protected RequestLoggerFunctionLog(final int executionId) {
		super(RequestLogger.RequestType.GET_INVOCATIONS);
		this.executionId = executionId;
	}

	public int getExecutionId() {
		return executionId;
	}
}
