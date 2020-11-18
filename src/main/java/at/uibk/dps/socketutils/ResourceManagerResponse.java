package at.uibk.dps.socketutils;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;
import at.uibk.dps.socketutils.entity.Status;

/**
 * This class is used to define the response from the resource
 * manager module (sent to the implementation selector).
 *
 * @author stefanpedratscher
 */
public class ResourceManagerResponse {

    /**
     * status of the response.
     */
    private Status status;

    /**
     * Filtered function links after resource manager
     * applied the decision.
     */
    protected final List<FunctionDetails> filteredFunctionLinks;

    /**
     * Default constructor for resource manager response.
     *
     * @param filteredFunctionLinks after resource manager
     *                              applied it's decision
     */
    public ResourceManagerResponse(final List<FunctionDetails> filteredFunctionLinks) {
        this.filteredFunctionLinks = filteredFunctionLinks;
    }

    /** Getter and Setter */

    public List<FunctionDetails> getFilteredFunctionLinks() {
        return filteredFunctionLinks;
    }
}
