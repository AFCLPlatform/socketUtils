package at.uibk.dps.communication;


import at.uibk.dps.communication.entity.Execution;
import at.uibk.dps.communication.entity.Invocation;
import at.uibk.dps.communication.entity.LoggerRequestType;

/**
 * This class is used to define the request which will be sent
 * to the invocation log manager module.
 *
 * @author stefanpedratscher
 */
public class InvocationLogManagerRequest {

    /**
     * Type of the request.
     */
    private LoggerRequestType requestType;

    /**
     * Identifier of the execution.
     */
    private int executionId;

    /**
     * Execution details.
     */
    private Execution execution;

    /**
     * Invocation details.
     */
    private Invocation invocation;

    /**
     * Resource link of the function.
     */
    private String functionLink;

    /** Constructors */

    public InvocationLogManagerRequest(LoggerRequestType requestType, String functionLink) {
        this.requestType = requestType;
        this.functionLink = functionLink;
    }

    public InvocationLogManagerRequest(LoggerRequestType requestType, int executionId) {
        this.requestType = requestType;
        this.executionId = executionId;
    }

    public InvocationLogManagerRequest(LoggerRequestType requestType, Execution execution, int executionId) {
        this.requestType = requestType;
        this.execution = execution;
        this.executionId = executionId;
    }

    public InvocationLogManagerRequest(LoggerRequestType requestType, Invocation invocation, int executionId) {
        this.requestType = requestType;
        this.invocation = invocation;
        this.executionId = executionId;
    }

    public InvocationLogManagerRequest(LoggerRequestType requestType) {
        this.requestType = requestType;
    }

    /** Getter and Setter */

    public LoggerRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(LoggerRequestType requestType) {
        this.requestType = requestType;
    }

    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }

    public Execution getExecution() {
        return execution;
    }

    public void setExecution(Execution execution) {
        this.execution = execution;
    }

    public Invocation getInvocation() {
        return invocation;
    }

    public void setInvocation(Invocation invocation) {
        this.invocation = invocation;
    }

    public String getFunctionLink() {
        return functionLink;
    }

    public void setFunctionLink(String functionLink) {
        this.functionLink = functionLink;
    }
}
