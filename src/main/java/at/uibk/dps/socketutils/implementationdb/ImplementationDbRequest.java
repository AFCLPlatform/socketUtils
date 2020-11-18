package at.uibk.dps.socketutils.implementationdb;

/**
 * The {@link ImplementationDbRequest} is used to query the implementation DB
 * module for all possibilities to implement a certain function type.
 * 
 * @author Fedor Smirnov
 */
public class ImplementationDbRequest {

	/**
	 * The requested function type.
	 */
	protected final String functionType;
	
	/**
	 * Setter constructor (used by the {@link ImplementationDbSocketUtils}.)
	 * 
	 * @param functionType
	 */
	protected ImplementationDbRequest(final String functionType) {
		this.functionType = functionType;
	}
}
