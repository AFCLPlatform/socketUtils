package at.uibk.dps.communication.entity;

import java.sql.Timestamp;

/**
 * Represents an invocation of a cloud function.
 *
 * @author stefanpedratscher
 */
public class Invocation {

    /**
     * Function resource link to invoke.
     */
    private String functionLink;

    /**
     * Provider on which the cloud function is invoked.
     */
    private String provider;

    /**
     * Region in which the cloud function is invoked.
     */
    private String region;

    /**
     * Invocation time of the cloud function.
     */
    private Timestamp invokeTime;

    /**
     * Response time of the cloud function.
     */
    private Timestamp returnTime;

    /**
     * Actual execution time in ms of the cloud function.
     */
    private long executionTime;

    /**
     * Exit status of the cloud function. OK or ERROR.
     */
    private String status;

    /**
     * The error message if an error occured.
     */
    private String errorMessage;

    /**
     * Execution identifier to which the cloud function belongs.
     */
    private int executionId;

    /**
     * Constructor for an invocation.
     *
     * @param functionLink  resource link to invoke.
     * @param provider      on which the cloud function is invoked.
     * @param region        in which the cloud function is invoked.
     * @param invokeTime    of the cloud function.
     * @param returnTime    of the cloud function.
     * @param executionTime in ms of the cloud function.
     * @param status        exit status of the cloud function. OK or ERROR.
     * @param errorMessage  if an error occured.
     * @param executionId   identifier to which the cloud function belongs.
     */
    public Invocation(String functionLink, String provider, String region,
                      Timestamp invokeTime, Timestamp returnTime, long executionTime,
                      String status, String errorMessage, int executionId) {
        this.functionLink = functionLink;
        this.provider = provider;
        this.region = region;
        this.invokeTime = invokeTime;
        this.returnTime = returnTime;
        this.executionTime = executionTime;
        this.status = status;
        this.errorMessage = errorMessage;
        this.executionId = executionId;
    }

    /**
     * Getter and Setter.
     */

    public String getFunctionLink() {
        return functionLink;
    }

    public void setFunctionLink(String functionLink) {
        this.functionLink = functionLink;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Timestamp getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(Timestamp invokeTime) {
        this.invokeTime = invokeTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }
}
