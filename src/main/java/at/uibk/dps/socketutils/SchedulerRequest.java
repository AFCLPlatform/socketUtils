package at.uibk.dps.socketutils;


/**
 * This class is used to define the request which will be sent
 * from the AFCLPortal to the scheduler module.
 *
 * @author stefanpedratscher
 */
public class SchedulerRequest {

    /**
     * Content of the workflow yaml file.
     */
    private byte[] workflowFile;

    /**
     * Content of the workflow input json file.
     */
    private byte[] schedulerConfig;

    /**
     * Content of the workflow input json file.
     */
    private byte[] workflowInput;

    /**
     * Default constructor.
     *
     * @param workflowFile content of the workflow file.
     */
    public SchedulerRequest(final byte[] workflowFile) {
        this(workflowFile, null, null);
    }

    /**
     * Constructor for scheduler request
     *
     * @param workflowFile content of the workflow file.
     * @param workflowInput content of the workflow input file.
     * @param schedulerConfig content of the config file.
     */
    public SchedulerRequest(final byte[] workflowFile, final byte[] workflowInput, final byte[] schedulerConfig){
        this.workflowFile = workflowFile.clone();
        this.workflowInput = workflowInput.clone();
        this.schedulerConfig = schedulerConfig.clone();
    }

    /** Getter and Setter */

    public byte[] getWorkflowFile() {
        return workflowFile.clone();
    }

    public void setWorkflowFile(final byte[] workflowFile) {
        this.workflowFile = workflowFile.clone();
    }

    public byte[] getWorkflowInput() { return workflowInput.clone(); }

    public void setWorkflowInput(final byte[] workflowInput) { this.workflowInput = workflowInput.clone(); }

    public byte[] getSchedulerConfig() { return schedulerConfig.clone(); }

    public void setSchedulerConfig(final byte[] schedulerConfig) { this.schedulerConfig = schedulerConfig.clone();}
}
