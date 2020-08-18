package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.FunctionDetails;
import at.uibk.dps.communication.entity.Status;

import java.util.List;

/**
 * This class is used to define the response from
 * the resource manager module.
 *
 * @author stefanpedratscher
 */
public class ResourceManagerResponse {

    /**
     * Default constructor.
     */
    public ResourceManagerResponse(){}

    /**
     * status of the response.
     */
    private Status status;

    /**
     * Filtered function links after resource manager
     * applied the decision.
     */
    private List<FunctionDetails> filteredFunctionLinks;

    /**
     * Default constructor for resource manager response.
     *
     * @param filteredFunctionLinks after resource manager
     *                              applied it's decision
     */
    public ResourceManagerResponse(List<FunctionDetails> filteredFunctionLinks) {
        this.filteredFunctionLinks = filteredFunctionLinks;
    }

    /** Getter and Setter */

    public List<FunctionDetails> getFilteredFunctionLinks() {
        return filteredFunctionLinks;
    }

    public void setFilteredFunctionLinks(List<FunctionDetails> filteredFunctionLinks) {
        this.filteredFunctionLinks = filteredFunctionLinks;
    }
}
