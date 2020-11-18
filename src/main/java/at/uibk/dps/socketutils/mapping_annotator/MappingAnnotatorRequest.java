package at.uibk.dps.socketutils.mapping_annotator;

/**
 * Parent class of all requests of the mapping annotator.
 * 
 * @author Fedor Smirnov
 */
public class MappingAnnotatorRequest {

	/**
	 * The different types of requests sent to the mapping annotator.
	 * 
	 * @author Fedor Smirnov
	 *
	 */
	public enum RequestType {
		/**
		 * Request for the annotation of the execution time of a mapping
		 */
		MAPPING_EXEC_TIME_REQUEST,
		/**
		 * Request for the init of the mapping annotator
		 */
		INIT_REQUEST
	}

	protected final RequestType requestType;

	/**
	 * Any request must set its type.
	 * 
	 * @param requestType
	 */
	protected MappingAnnotatorRequest(final RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestType getRequestType() {
		return requestType;
	}
}
