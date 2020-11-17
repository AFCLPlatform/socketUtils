package at.uibk.dps.communication.logging;

/**
 * Parent class for all requests to the logger.
 * 
 * @author Fedor Smirnov
 *
 */
public abstract class LoggerRequest {

	public enum RequestType {
		GET_EXECUTION_ID, UPDATE_EXECUTION, INSERT_EXECUTION, INSERT_INVOCATION, GET_INVOCATIONS, GET_AVG_EXEC_TIME
	}

	protected final RequestType requestType;

	/**
	 * Every logger request is assigned a type when it is created.
	 * 
	 * @param requestType the type of the request.
	 */
	public LoggerRequest(final RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestType getRequestType() {
		return requestType;
	}
}
