package at.uibk.dps.socketutils;

import at.uibk.dps.socketutils.entity.ResourceRequestType;

/**
 * This class is used to define the request which will be sent
 * from the scheduler to the implementation selector module.
 *
 * @author stefanpedratscher
 */
public class SelectorRequest {

    /**
     * Function type.
     */
    protected final String functionType;

    /**
     * Request type for a resource.
     */
    protected final ResourceRequestType requestType;

    /**
     * Default constructor.
     *
     * @param functionType of the function.
     * @param requestType of the request.
     */
    protected SelectorRequest(final String functionType, final ResourceRequestType requestType) {
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
