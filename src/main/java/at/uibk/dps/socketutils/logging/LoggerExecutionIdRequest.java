package at.uibk.dps.socketutils.logging;

/**
 * Request for the creation of the execution ID.
 * 
 * @author Fedor Smirnov
 *
 */
public class LoggerExecutionIdRequest extends LoggerRequest {

	/**
	 * No attributes necessary
	 */
	protected LoggerExecutionIdRequest() {
		super(LoggerRequest.RequestType.GET_EXECUTION_ID);
	}
}
