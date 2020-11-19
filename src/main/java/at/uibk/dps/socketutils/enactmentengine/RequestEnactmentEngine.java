package at.uibk.dps.socketutils.enactmentengine;

/**
 * This class is used to define the request which will be sent from the
 * scheduler or AFCLPortal to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class RequestEnactmentEngine {

	/**
	 * Content of the workflow yaml file.
	 */
	protected final byte[] workflowFileContent;

	/**
	 * Content of the workflow input json file.
	 */
	protected final byte[] workflowInputFileContent;

	/**
	 * Log results in database
	 */
	protected final boolean logResults;

	/**
	 * Default constructor.
	 *
	 * @param workflowFile content of the workflow file.
	 */
	public RequestEnactmentEngine(final byte[] workflowFile, final boolean logResults) {
		this(workflowFile, null, logResults);
	}

	/**
	 * Constructor for enactment engine request
	 *
	 * @param workflowFileContent      content of the workflow file.
	 * @param workflowInputFileContent content of the workflow input file.
	 */
	public RequestEnactmentEngine(final byte[] workflowFileContent, final byte[] workflowInputFileContent,
			final boolean logResults) {
		this.logResults = logResults;
		this.workflowFileContent = workflowFileContent.clone();
		this.workflowInputFileContent = workflowInputFileContent.clone();
	}

	public byte[] getWorkflowFileContent() {
		return workflowFileContent.clone();
	}

	public byte[] getWorkflowInputFileContent() {
		return workflowInputFileContent.clone();
	}

	public boolean isLogResults() {
		return logResults;
	}
}
