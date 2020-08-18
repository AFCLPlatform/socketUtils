package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.FunctionDetails;
import at.uibk.dps.communication.entity.ResourceRequestType;

import java.util.List;

/**
 * This class is used to define the request which will be sent
 * to the resource manager module.
 *
 * @author stefanpedratscher
 */
public class ResourceManagerRequestFactory {

    /**
     * Get a request for the free function invocations.
     *
     * @param functionLinks function links.
     * @return resource manager request.
     */
    public static ResourceManagerRequest getFreeResourcesByFunctions(List<FunctionDetails> functionLinks) {
        return new ResourceManagerRequest(ResourceRequestType.GET_FREE_RESOURCES, functionLinks);
    }
}
