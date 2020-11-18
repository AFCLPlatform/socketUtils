package at.uibk.dps.socketutils;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;
import at.uibk.dps.socketutils.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent from
 * the implementation selector to the resource manager module.
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

    /**
     * Get a request for the all function invocations.
     *
     * @param functionLinks function links.
     * @return resource manager request.
     */
    public static ResourceManagerRequest getAllResourcesByFunctions(List<FunctionDetails> functionLinks) {
        return new ResourceManagerRequest(ResourceRequestType.GET_ALL_RESOURCES, functionLinks);
    }
}
