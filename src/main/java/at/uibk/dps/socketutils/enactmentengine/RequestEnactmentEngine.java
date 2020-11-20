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
	 * True iff the WF is executed with input.
	 */
	protected final boolean executedWithInput;

	/**
	 * Default constructor.
	 *
	 * @param workflowFile content of the workflow file.
	 * @param logResults   true iff the results shall be logged
	 */
	protected RequestEnactmentEngine(final byte[] workflow, final boolean logResults) {
		this.logResults = logResults;
		this.workflow = workflow.clone();
		this.workflowInput = new byte[1];
		this.executedWithInput = false;
	}

	/**
	 * Constructor for enactment engine request
	 *
	 * @param workflow      content of the workflow file.
	 * @param workflowInput content of the workflow input file.
	 * @param
	 */
	protected RequestEnactmentEngine(final byte[] workflow, final byte[] workflowInput, final boolean logResults) {
		this.logResults = logResults;
		this.workflow = workflow.clone();
		this.workflowInput = workflowInput.clone();
		this.executedWithInput = true;
	}

	public byte[] getWorkflow() {
		return workflow.clone();
	}

	public boolean isExecutedWithInput() {
		return executedWithInput;
	}

	/**
	 * Getter for the WF input. Throws an {@link IllegalStateException} is WF not
	 * set. Use the isExecutedWithInput() to check for the setting of the input.
	 * 
	 * @return the wf input
	 */
	public byte[] getWorkflowInput() {
		if (executedWithInput) {
			return workflowInput.clone();
		} else {
			throw new IllegalStateException("Workflow input not set, but requested.");
		}
	}

	public boolean isLogResults() {
		return logResults;
	}
}
