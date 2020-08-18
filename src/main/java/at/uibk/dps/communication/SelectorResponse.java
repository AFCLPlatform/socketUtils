package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.FunctionDetails;

import java.util.List;

/**
 * This class is used to define the response from
 * the implementation selector module.
 *
 * @author stefanpedratscher
 */
public class SelectorResponse extends ResourceManagerResponse{

    /**
     * Default constructor for filtered function links.
     * @param filteredFunctionLinks list of functions.
     */
    public SelectorResponse(List<FunctionDetails> filteredFunctionLinks) {
        super(filteredFunctionLinks);
    }
}
