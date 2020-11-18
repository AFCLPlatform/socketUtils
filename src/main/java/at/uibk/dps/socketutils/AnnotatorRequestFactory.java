package at.uibk.dps.socketutils;

import at.uibk.dps.socketutils.AnnotatorRequest.AnnotatorRequestType;

/**
 * This class is used to define the request which will be sent
 * from the scheduler to the mapping annotator module.
 *
 * @author stefanpedratscher
 */
public class AnnotatorRequestFactory {

    /**
     * Return a mapping annotator request to get average execution times of a function.
     */
    public static AnnotatorRequest getAverageFunctionExecutionTimeRequest(String functionLink) {
        return new AnnotatorRequest(AnnotatorRequestType.GET_AVG_EXEC_TIME, functionLink);
    }
}
