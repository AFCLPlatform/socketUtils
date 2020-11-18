package at.uibk.dps.socketutils.implementationdb;

import at.uibk.dps.socketutils.entity.FunctionDetails;

import java.util.List;

/**
 * Static method container for the creation of the messages from and to the
 * implementation DB.
 * 
 * @author Fedor Smirnov
 */
public final class ImplementationDbSocketUtils {

	/**
	 * Static container => no constructor
	 */
	private ImplementationDbSocketUtils() {
	}

	/**
	 * Generates a request requesting all implementations for the requested function
	 * type.
	 * 
	 * @param functionType the requested function type.
	 * @return a request requesting all implementations for the requested function
	 *         type
	 */
	public static ImplementationDbRequest generateRequest(final String functionType) {
		return new ImplementationDbRequest(functionType);
	}

	/**
	 * Generates a response containing all implementations for a previous request.
	 * 
	 * @param implementationDetails the list of possible implementations
	 * @return a response containing all implementations for a previous request
	 */
	public static ImplementationDbResponse generateResponse(final List<FunctionDetails> implementationDetails) {
		return new ImplementationDbResponse(implementationDetails);
	}
}
