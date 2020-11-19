package at.uibk.dps.socketutils.resourcemanager;

/**
 * Parent class for the requests to the resource manager.
 * 
 * @author Fedor Smirnov
 *
 */
public class RequestResourceManager {

	/**
	 * Possible request types to the resource manager.
	 */
	public enum RequestType {
		GET_FREE_RESOURCES, GET_ALL_RESOURCES
	}

	/**
	 * String identifying the requested function type
	 */
	protected final String functionType;

	/**
	 * Object defining the details of the resource request
	 */
	protected final RequestType requestType;

	/**
	 * Every {@link RequestResourceManager} must have a defined type.
	 * 
	 * @param requestType the type of the constructed request.
	 */
	protected RequestResourceManager(final String functionType, final RequestType requestType) {
		this.functionType = functionType;
		this.requestType = requestType;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public String getFunctionType() {
		return functionType;
	}
}
