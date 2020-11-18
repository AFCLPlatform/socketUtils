package at.uibk.dps.socketutils.resourcemanager;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;

/**
 * This class is used to define the request which will be sent from the
 * implementation selector to the resource manager module.
 *
 * @author stefanpedratscher
 */
public final class ResourceManagerSocketUtils {

	/**
	 * Class is a static method constructor.
	 */
	private ResourceManagerSocketUtils() {
	}

	/**
	 * Get a request for the free function invocations.
	 *
	 * @param functionLinks function links.
	 * @return resource manager request.
	 */
	public static ResourceManagerRequestFree generateRequestFree(final String functionType) {
		return new ResourceManagerRequestFree(functionType);
	}

	/**
	 * Get a request for the all function invocations.
	 *
	 * @param functionLinks function links.
	 * @return resource manager request.
	 */
	public static ResourceManagerRequestAll generateRequestAll(final String functionType) {
		return new ResourceManagerRequestAll(functionType);
	}

	/**
	 * Generates a response containing the filtered function implementations for a
	 * previous request.
	 * 
	 * @param filteredImplementations the list of filtered implementations
	 * @return a response containing the filtered function implementations for a
	 *         previous request
	 */
	public static ResourceManagerResponse generateResponse(final List<FunctionDetails> filteredImplementations) {
		return new ResourceManagerResponse(filteredImplementations);
	}
}
