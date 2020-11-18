package at.uibk.dps.socketutils;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;
import at.uibk.dps.socketutils.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent from the
 * implementation selector to the resource manager module.
 *
 * @author stefanpedratscher
 */
public class ResourceManagerRequest {

	/**
	 * The request type.
	 */
	protected final ResourceRequestType requestType;

	/**
	 * All possible function links which will be filtered.
	 */
	protected final List<FunctionDetails> possibleFunctionLinks;

	/**
	 * Constructor for a request to the resource manager module.
	 *
	 * @param requestType           of the request.
	 * @param possibleFunctionLinks all possible function links.
	 */
	protected ResourceManagerRequest(final ResourceRequestType requestType,
			final List<FunctionDetails> possibleFunctionLinks) {
		this.requestType = requestType;
		this.possibleFunctionLinks = possibleFunctionLinks;
	}

	/** Getter and Setter */

	public ResourceRequestType getRequestType() {
		return requestType;
	}

	public List<FunctionDetails> getPossibleFunctionLinks() {
		return possibleFunctionLinks;
	}
}
