package at.uibk.dps.socketutils.resourcemanager;

/**
 * This class is used to define a request for all free resources which can be
 * used to deploy a list of provided function links.
 * 
 * @author Fedor Smirnov
 */
public class ResourceManagerRequestFree extends ResourceManagerRequest {

	/**
	 * Constructor for a free-resources request to the resource manager module.
	 *
	 * @param functionType          functionType
	 * @param requestType           of the request.
	 * @param possibleFunctionLinks all possible function links.
	 */
	protected ResourceManagerRequestFree(final String functionType) {
		super(functionType, RequestType.GET_FREE_RESOURCES);
	}

}
