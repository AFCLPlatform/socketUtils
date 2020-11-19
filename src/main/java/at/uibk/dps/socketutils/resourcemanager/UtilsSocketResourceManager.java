package at.uibk.dps.socketutils.resourcemanager;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;

/**
 * This class is used to define the request which will be sent from the
 * implementation selector to the resource manager module.
 *
 * @author stefanpedratscher
 */
public final class UtilsSocketResourceManager {

	/**
	 * Class is a static method constructor.
	 */
	private UtilsSocketResourceManager() {
	}

	/**
	 * Get a request for the free function invocations.
	 *
	 * @param functionLinks function links.
	 * @return resource manager request.
	 */
	public static RequestResourceManagerFree generateRequestFree(final String functionType) {
		return new RequestResourceManagerFree(functionType);
	}

	/**
	 * Get a request for the all function invocations.
	 *
	 * @param functionLinks function links.
	 * @return resource manager request.
	 */
	public static RequestResourceManagerAll generateRequestAll(final String functionType) {
		return new RequestResourceManagerAll(functionType);
	}

	/**
	 * Generates a response containing the filtered function implementations for a
	 * previous request.
	 * 
	 * @param filteredImplementations the list of filtered implementations
	 * @return a response containing the filtered function implementations for a
	 *         previous request
	 */
	public static ResponseResourceManager generateResponse(final List<FunctionDetails> filteredImplementations) {
		return new ResponseResourceManager(filteredImplementations);
	}
}
