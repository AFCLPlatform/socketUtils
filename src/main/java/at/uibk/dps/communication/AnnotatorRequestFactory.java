package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.AnnotatorRequestType;

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
