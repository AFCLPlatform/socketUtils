package at.uibk.dps.socketutils.implementationdb;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;

/**
 * The {@link ImplementationDbResponse} is used to wrap the response of the
 * implementation db containing all implementations for a requested function
 * type.
 * 
 * @author Fedor Smirnov
 */
public class ImplementationDbResponse {

	/**
	 * The list of all implementations available for the requested function type.
	 */
	protected final List<FunctionDetails> implementations;

	/**
	 * Setter constructor (used by the {@link ImplementationDbSocketUtils}).
	 * 
	 * @param implementations
	 */
	protected ImplementationDbResponse(final List<FunctionDetails> implementations) {
		this.implementations = implementations;
	}

	public List<FunctionDetails> getImplementations() {
		return implementations;
	}
}
