package at.uibk.dps.socketutils;

import java.util.List;

import at.uibk.dps.socketutils.entity.FunctionDetails;

/**
 * This class is used to define the response from the
 * implementation selector module (sent to the scheduler).
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
