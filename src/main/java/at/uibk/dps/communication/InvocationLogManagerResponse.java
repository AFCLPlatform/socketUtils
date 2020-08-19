package at.uibk.dps.communication;


import at.uibk.dps.communication.entity.Invocation;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class is used to define the response of
 * the invocation log manager module.
 *
 * @author stefanpedratscher
 */
public class InvocationLogManagerResponse {

    /**
     * Execution identifier.
     */
    private int executionId;

    /**
     * Average execution time.
     */
    private BigDecimal avgExecutionTime;

    /**
     * Invocations.
     */
    private List<Invocation> invocations;

    /** Constructors */

    public InvocationLogManagerResponse() { }

    public InvocationLogManagerResponse(int executionId) {
        this.executionId = executionId;
    }

    public InvocationLogManagerResponse(BigDecimal avgExecutionTime) {
        this.avgExecutionTime = avgExecutionTime;
    }

    public InvocationLogManagerResponse(List<Invocation> invocations) {
        this.invocations = invocations;
    }

    /** Getter and Setter */

    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }

    public BigDecimal getAvgExecutionTime() {
        return avgExecutionTime;
    }

    public void setAvgExecutionTime(BigDecimal avgExecutionTime) {
        this.avgExecutionTime = avgExecutionTime;
    }

    public List<Invocation> getInvocations() {
        return invocations;
    }

    public void setInvocations(List<Invocation> invocations) {
        this.invocations = invocations;
    }
}
