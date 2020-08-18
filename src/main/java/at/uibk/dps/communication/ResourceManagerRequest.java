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
public class ResourceManagerRequest {

    /**
     * The request type.
     */
    private ResourceRequestType requestType;

    /**
     * All possible function links which will be filtered.
     */
    private List<FunctionDetails> possibleFunctionLinks;

    /**
     * Constructor for a request to the resource manager module.
     *
     * @param requestType of the request.
     * @param possibleFunctionLinks all possible function links.
     */
    ResourceManagerRequest(ResourceRequestType requestType, List<FunctionDetails> possibleFunctionLinks) {
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
