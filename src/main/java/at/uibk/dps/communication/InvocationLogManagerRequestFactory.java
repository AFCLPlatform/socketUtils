package at.uibk.dps.communication;


import at.uibk.dps.communication.entity.Execution;
import at.uibk.dps.communication.entity.LoggerRequestType;

/**
 * This class is used to define the request which will be sent
 * to the invocation log manager module.
 *
 * @author stefanpedratscher
 */
public class InvocationLogManagerRequestFactory {

    /**
     * Return a invocation request to get the execution identifier.
     */
    public static InvocationLogManagerRequest getExecutionIdRequest() {
        return new InvocationLogManagerRequest(LoggerRequestType.GET_EXECUTION_ID);
    }

    /**
     * Return a invocation request to get the execution identifier.
     */
    public static InvocationLogManagerRequest getUpdateExecutionLogsRequest(Execution execution) {
        return new InvocationLogManagerRequest(LoggerRequestType.UPDATE_EXECUTION, execution);
    }

    /**
     * Return a invocation request to get the execution identifier.
     */
    public static InvocationLogManagerRequest getFunctionInvocationLogsRequest(int executionId) {
        return new InvocationLogManagerRequest(LoggerRequestType.GET_INVOCATIONS, executionId);
    }
}
