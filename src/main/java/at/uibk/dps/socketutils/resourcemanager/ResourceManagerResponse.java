package at.uibk.dps.socketutils.resourcemanager;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;

/**
 * This class is used to define the response from the resource
 * manager module (sent to the implementation selector).
 *
 * @author stefanpedratscher
 */
public class ResourceManagerResponse {

    /**
     * Filtered function links after resource manager
     * applied the decision.
     */
    protected final List<FunctionDetails> filteredImplementations;

    /**
     * Default constructor for resource manager response.
     *
     * @param filteredFunctionLinks after resource manager
     *                              applied it's decision
     */
    public ResourceManagerResponse(final List<FunctionDetails> filteredFunctionLinks) {
        this.filteredImplementations = filteredFunctionLinks;
    }

    public List<FunctionDetails> getFilteredImplementations() {
        return filteredImplementations;
    }
}
