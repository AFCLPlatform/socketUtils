package at.uibk.dps.communication;


/**
 * This class is used to define the request which will be sent
 * to the scheduler module.
 *
 * @author stefanpedratscher
 */
public class SchedulerRequest {

    /**
     * Content of the workflow yaml file.
     */
    private byte[] workflowFileContent;

    /**
     * Content of the workflow input json file.
     */
    private byte[] schedulerConfigContent;

    /**
     * Content of the workflow input json file.
     */
    private byte[] workflowInputFileContent;

    /**
     * Default constructor.
     *
     * @param workflowFileContent content of the workflow file.
     */
    public SchedulerRequest(byte[] workflowFileContent) {
        this(workflowFileContent, null, null);
    }

    /**
     * Constructor for scheduler request
     *
     * @param workflowFileContent content of the workflow file.
     * @param workflowInputFileContent content of the workflow input file.
     * @param schedulerConfigContent content of the config file.
     */
    public SchedulerRequest(byte[] workflowFileContent, byte[] workflowInputFileContent, byte[] schedulerConfigContent){
        this.workflowFileContent = workflowFileContent;
        this.workflowInputFileContent = workflowInputFileContent;
        this.schedulerConfigContent = schedulerConfigContent;
    }

    /** Getter and Setter */

    public byte[] getWorkflowFileContent() {
        return workflowFileContent;
    }

    public void setWorkflowFileContent(byte[] workflowFileContent) {
        this.workflowFileContent = workflowFileContent;
    }

    public byte[] getWorkflowInputFileContent() { return workflowInputFileContent; }

    public void setWorkflowInputFileContent(byte[] workflowInputFileContent) { this.workflowInputFileContent = workflowInputFileContent; }

    public byte[] getSchedulerConfigContent() { return schedulerConfigContent; }

    public void setSchedulerConfigContent(byte[] schedulerConfigContent) { this.schedulerConfigContent = schedulerConfigContent; }
}
