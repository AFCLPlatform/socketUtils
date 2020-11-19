package at.uibk.dps.socketutils.logger;

/**
 * Parent class for all requests to the logger.
 * 
 * @author Fedor Smirnov
 *
 */
public class RequestLogger {

	/**
	 * Enum for the different types of requests which can be made to the logger.
	 * 
	 * @author Fedor Smirnov
	 */
	public enum RequestType {
		GET_EXECUTION_ID, UPDATE_EXECUTION, INSERT_EXECUTION, INSERT_INVOCATION, GET_INVOCATIONS, GET_AVG_EXEC_TIME
	}

	protected final RequestType requestType;

	/**
	 * Every logger request is assigned a type when it is created.
	 * 
	 * @param requestType the type of the request.
	 */
	protected RequestLogger(final RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestType getRequestType() {
		return requestType;
	}
}
