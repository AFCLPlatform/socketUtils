package at.uibk.dps.socketutils.logger;

/**
 * Request for the creation of the execution ID.
 * 
 * @author Fedor Smirnov
 *
 */
public class LoggerRequestExecutionId extends LoggerRequest {

	/**
	 * No attributes necessary
	 */
	protected LoggerRequestExecutionId() {
		super(LoggerRequest.RequestType.GET_EXECUTION_ID);
	}
}
