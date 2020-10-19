package at.uibk.dps.communication;


/**
 * This class is used to define the request which will be sent from
 * the scheduler or AFCLPortal to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequest {

    /**
     * Content of the workflow yaml file.
     */
    private byte[] workflowFileContent;

    /**
     * Content of the workflow input json file.
     */
    private byte[] workflowInputFileContent;

    /**
     * Log results in database
     */
    boolean logResults;

    /**
     * Default constructor.
     *
     * @param workflowFileContent content of the workflow file.
     */
    public EnactmentEngineRequest(byte[] workflowFileContent, boolean logResults) {
        this(workflowFileContent, null, logResults);
    }

    /**
     * Constructor for enactment engine request
     *
     * @param workflowFileContent content of the workflow file.
     * @param workflowInputFileContent content of the workflow input file.
     */
    public EnactmentEngineRequest(byte[] workflowFileContent, byte[] workflowInputFileContent, boolean logResults){
        this.logResults = logResults;
        this.workflowFileContent = workflowFileContent;
        this.workflowInputFileContent = workflowInputFileContent;
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

    public boolean isLogResults() { return logResults; }

    public void setLogResults(boolean logResults) { this.logResults = logResults; }
}
