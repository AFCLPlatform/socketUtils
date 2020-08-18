package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent
 * to the implementation selector module.
 *
 * @author stefanpedratscher
 */
public class SelectorRequest {

    /**
     * Function type.
     */
    private String functionType;

    /**
     * Request type for a resource.
     */
    private ResourceRequestType requestType;

    /**
     * Default constructor.
     *
     * @param functionType of the function.
     * @param requestType of the request.
     */
    SelectorRequest(String functionType, ResourceRequestType requestType) {
        this.functionType = functionType;
        this.requestType = requestType;
    }

    /** Getter and Setter */

    public String getFunctionType() {
        return functionType;
    }

    public ResourceRequestType getRequestType() {
        return requestType;
    }
}
