package at.uibk.dps.socketutils.resourcemanager;

/**
 * This class is used to define a request for all resources which can be used to
 * deploy a list of provided function links.
 *
 * @author stefanpedratscher
 */
public class RequestResourceManagerAll extends RequestResourceManager {

	/**
	 * Constructor for an all-resources request to the resource manager module.
	 *
	 * @param functionType          the requested function type
	 * @param requestType           of the request.
	 * @param possibleFunctionLinks all possible function links.
	 */
	protected RequestResourceManagerAll(final String functionType) {
		super(functionType, RequestType.GET_ALL_RESOURCES);
	}
}
