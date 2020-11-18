package at.uibk.dps.socketutils.entity;

/**
 * Contains several details for a function.
 *
 * @author stefanpedratscher
 */
public class FunctionDetails {

	/**
	 * Programming language in which the function is written.
	 */
	protected final String language;

	/**
	 * Resource link of the function.
	 */
	protected final String functionLink;

	/**
	 * If there are any free invocations.
	 */
	protected final boolean freeInvocations;

	/**
	 * Default constructor for function details.
	 *
	 * @param language        programming language of the function.
	 * @param functionLink    resource link of the function.
	 * @param freeInvocations if there are free invocations.
	 */
	public FunctionDetails(final String language, final String functionLink, final boolean freeInvocations) {
		this.language = language;
		this.functionLink = functionLink;
		this.freeInvocations = freeInvocations;
	}

	/** Getter and Setter */

	public String getLanguage() {
		return language;
	}

	public String getFunctionLink() {
		return functionLink;
	}

	public boolean isFreeInvocations() {
		return freeInvocations;
	}
}