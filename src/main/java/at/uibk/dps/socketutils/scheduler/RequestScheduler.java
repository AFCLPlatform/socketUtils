package at.uibk.dps.socketutils.scheduler;

/**
 * This class is used to define the request from the web portal to the scheduler
 * module.
 *
 * @author stefanpedratscher
 */
public class RequestScheduler {

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

	protected final boolean scheduleConfigSet;

	protected final boolean workFlowInputSet;

	/**
	 * Default constructor.
	 *
	 * @param workflow content of the workflow file.
	 */
	public RequestScheduler(final byte[] workflow) {
		this.workflow = workflow;
		this.schedulerConfig = new byte[1];
		this.workflowInput = new byte[1];
		this.scheduleConfigSet = false;
		this.workFlowInputSet = false;
	}

	/**
	 * Constructor for scheduler request
	 *
	 * @param workflow        content of the workflow file.
	 * @param workflowInput   content of the workflow input file.
	 * @param schedulerConfig content of the config file.
	 */
	public RequestScheduler(final byte[] workflow, final byte[] workflowInput, final byte[] schedulerConfig) {
		this.workflow = workflow.clone();
		this.workflowInput = workflowInput.clone();
		this.schedulerConfig = schedulerConfig.clone();
		this.workFlowInputSet = true;
		this.scheduleConfigSet = true;
	}
	
	/**
	 * Constructor for the case without input
	 * 
	 * @param workflow the wf
	 * @param schedulerConfig the scheduler configuration
	 */
	public RequestScheduler(final byte[] workflow, final byte[] schedulerConfig) {
		this.workflow = workflow.clone();
		this.schedulerConfig = schedulerConfig.clone();
		this.workflowInput = new byte[1];
		this.scheduleConfigSet = true;
		this.workFlowInputSet = false;
	}

	public byte[] getWorkflow() {
		return workflow.clone();
	}

	public boolean isScheduleConfigSet() {
		return scheduleConfigSet;
	}

	public boolean isWorkFlowInputSet() {
		return workFlowInputSet;
	}

	public byte[] getWorkflowInput() {
		if (workFlowInputSet) {
			return workflowInput.clone();
		} else {
			throw new IllegalStateException("Workflow input not set, but requested from a scheduler request.");
		}
	}

	public byte[] getSchedulerConfig() {
		if (scheduleConfigSet) {
			return schedulerConfig.clone();
		} else {
			throw new IllegalStateException("Scheduler config not set, but requested from a scheduler request.");
		}
	}
}
