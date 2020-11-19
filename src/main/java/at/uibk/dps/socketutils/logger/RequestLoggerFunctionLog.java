package at.uibk.dps.socketutils.logger;

/**
 * The {@link RequestLoggerFunctionLog} is used to request function logs
 * with a given execution identifier.
 * 
 * @author fedor, stefanpedratscher
 *
 */
public class RequestLoggerFunctionLog extends RequestLogger {

	/**
	 * The execution identifier of the workflow execution.
	 */
	protected final int executionId;

	/**
	 * Request function logs of a specific execution.
	 *
	 * @param executionId identifier of the workflow execution.
	 */
	protected RequestLoggerFunctionLog(final int executionId) {
		super(RequestLogger.RequestType.GET_INVOCATIONS);
		this.executionId = executionId;
	}

	public int getExecutionId() {
		return executionId;
	}
}
