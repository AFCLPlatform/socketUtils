package at.uibk.dps.socketutils;

import at.uibk.dps.socketutils.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent from
 * the scheduler to the implementation selector module.
 *
 * @author stefanpedratscher
 */
public class SelectorRequestFactory {

	/**
	 * Returns the request for the resources for the provided function, following
	 * the conditions formulated in the request type.
	 * 
	 * @param functionType the function type
	 * @param requestType  the request type specifying the requested resources
	 * @return the request for the resources for the provided function, following
	 *         the conditions formulated in the request type
	 */
	public static SelectorRequest getResourcesByFunctionType(String functionType, ResourceRequestType requestType) {
		return new SelectorRequest(functionType, requestType);
	}
}
