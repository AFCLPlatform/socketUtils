package at.uibk.dps.socketutils.scheduler;

/**
 * This class is used to define the request from the web portal to the scheduler
 * module.
 *
 * @author stefanpedratscher
 */
public class SchedulerRequest {

	/**
	 * Content of the workflow yaml file.
	 */
	protected final byte[] workflow;

	/**
	 * Content of the workflow input json file.
	 */
	protected final byte[] schedulerConfig;

	/**
	 * Content of the workflow input json file.
	 */
	protected final byte[] workflowInput;

	/**
	 * Default constructor.
	 *
	 * @param workflow content of the workflow file.
	 */
	public SchedulerRequest(final byte[] workflow) {
		this(workflow, null, null);
	}

	/**
	 * Constructor for scheduler request
	 *
	 * @param workflow        content of the workflow file.
	 * @param workflowInput   content of the workflow input file.
	 * @param schedulerConfig content of the config file.
	 */
	public SchedulerRequest(final byte[] workflow, final byte[] workflowInput, final byte[] schedulerConfig) {
		this.workflow = workflow.clone();
		this.workflowInput = workflowInput.clone();
		this.schedulerConfig = schedulerConfig.clone();
	}

	public byte[] getWorkflow() {
		return workflow.clone();
	}

	public byte[] getWorkflowInput() {
		if (workflowInput == null) {
			throw new IllegalStateException("Workflow input not set, but requested from a scheduler request.");
		} else {
			return workflowInput.clone();
		}
	}

	public byte[] getSchedulerConfig() {
		if (schedulerConfig == null) {
			throw new IllegalStateException("Scheduler config not set, but requested from a scheduler request.");
		} else {
			return schedulerConfig.clone();
		}
	}
}
