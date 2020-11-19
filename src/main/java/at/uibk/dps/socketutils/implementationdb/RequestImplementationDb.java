package at.uibk.dps.socketutils.implementationdb;

/**
 * The {@link RequestImplementationDb} is used to query the implementation DB
 * module for all possibilities to implement a certain function type.
 * 
 * @author Fedor Smirnov
 */
public class RequestImplementationDb {

	/**
	 * The requested function type.
	 */
	protected final String functionType;

	/**
	 * Setter constructor (used by the {@link UtilsSocketImplementationDb}.)
	 * 
	 * @param functionType
	 */
	protected RequestImplementationDb(final String functionType) {
		this.functionType = functionType;
	}

	public String getFunctionType() {
		return functionType;
	}
}
