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
	protected final byte[] workflow;

	/**
	 * Content of the workflow input json file.
	 */
	protected final byte[] workflowInput;

	/**
	 * Log results in database
	 */
	protected final boolean logResults;

	/**
	 * Default constructor.
	 *
	 * @param workflowFile content of the workflow file.
	 */
	protected RequestEnactmentEngine(final byte[] workflowFile, final boolean logResults) {
		this(workflowFile, null, logResults);
	}

	/**
	 * Constructor for enactment engine request
	 *
	 * @param workflow      content of the workflow file.
	 * @param workflowInput content of the workflow input file.
	 */
	protected RequestEnactmentEngine(final byte[] workflow, final byte[] workflowInput,
			final boolean logResults) {
		this.logResults = logResults;
		this.workflow = workflow.clone();
		if (workflowInput == null) {
			this.workflowInput = null;
		} else {
			this.workflowInput = workflowInput.clone();
		}
	}

	public byte[] getWorkflow() {
		return workflow.clone();
	}

	public byte[] getWorkflowInput() {
		if (workflowInput == null) {
			throw new IllegalStateException("Workflow input not set, but requested.");
		} else {
			return workflowInput.clone();
		}
	}

	public boolean isLogResults() {
		return logResults;
	}
}
