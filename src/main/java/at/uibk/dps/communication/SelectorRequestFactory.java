package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent
 * to the implementation selector module.
 *
 * @author stefanpedratscher
 */
public class SelectorRequestFactory {

    /**
     * Return a selector request for free function resources.
     */
    public static SelectorRequest getFreeResourcesByFunctionType(String functionType) {
        return new SelectorRequest(functionType, ResourceRequestType.GET_FREE_RESOURCES);
    }
}
