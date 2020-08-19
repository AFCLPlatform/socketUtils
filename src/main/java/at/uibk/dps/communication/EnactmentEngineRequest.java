package at.uibk.dps.communication;


/**
 * This class is used to define the request which will be sent
 * to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequest {

    /**
     * Content of the workflow yaml file.
     */
    private byte[] workflowFileContent;

    /**
     * Default constructor.
     *
     * @param workflowFileContent content of the workflow file.
     */
    public EnactmentEngineRequest(byte[] workflowFileContent) {
        this.workflowFileContent = workflowFileContent;
    }

    /** Getter and Setter */

    public byte[] getWorkflowFileContent() {
        return workflowFileContent;
    }

    public void setWorkflowFileContent(byte[] workflowFileContent) {
        this.workflowFileContent = workflowFileContent;
    }
}
