package at.uibk.dps.socketutils.logger;

/**
 * Request for the creation of the execution ID.
 * 
 * @author Fedor Smirnov
 *
 */
public class RequestLoggerExecutionId extends RequestLogger {

	/**
	 * No attributes necessary
	 */
	protected RequestLoggerExecutionId() {
		super(RequestLogger.RequestType.GET_EXECUTION_ID);
	}
}
