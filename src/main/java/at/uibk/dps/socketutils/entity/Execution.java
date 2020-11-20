package at.uibk.dps.socketutils.entity;

import java.sql.Timestamp;

/**
 * Represents an execution of a workflow.
 *
 * @author stefanpedratscher
 */
public class Execution {

	/**
	 * Start time of the enactment engine.
	 */
	protected final Timestamp eeStart;

	/**
	 * End time of the enactment engine.
	 */
	protected final Timestamp eeEnd;

	/**
	 * Start time of the scheduler.
	 */
	protected final Timestamp schedulerStart;

	/**
	 * End time of the scheduler.
	 */
	protected final Timestamp schedulerEnd;

	/**
	 * Start time of the portal.
	 */
	protected final Timestamp portalStart;

	/**
	 * End time of the portal.
	 */
	protected final Timestamp portalEnd;

	/**
	 * Identifier of the workflow execution.
	 */
	protected final int executionId;

	/**
	 * True iff this execution shall be logged.
	 */
	protected final boolean beingLogged;

	/**
	 * Constructor for an execution which is not logged.
	 *
	 * @param eeStart        start time of the enactment engine.
	 * @param eeEnd          end time of the enactment engine.
	 * @param schedulerStart start time of the scheduler.
	 * @param schedulerEnd   end time of the scheduler.
	 * @param portalStart    start time of the portal.
	 * @param portalEnd      end time of the portal.
	 */
	public Execution(final Timestamp eeStart, final Timestamp eeEnd, final Timestamp schedulerStart,
			final Timestamp schedulerEnd, final Timestamp portalStart, final Timestamp portalEnd) {
		this.eeStart = eeStart;
		this.eeEnd = eeEnd;
		this.schedulerStart = schedulerStart;
		this.schedulerEnd = schedulerEnd;
		this.portalStart = portalStart;
		this.portalEnd = portalEnd;
		this.executionId = -1;
		this.beingLogged = false;
	}

	/**
	 * Constructor for an execution which is logged.
	 *
	 * @param eeStart        start time of the enactment engine.
	 * @param eeEnd          end time of the enactment engine.
	 * @param schedulerStart start time of the scheduler.
	 * @param schedulerEnd   end time of the scheduler.
	 * @param portalStart    start time of the portal.
	 * @param portalEnd      end time of the portal.
	 * @param executionId    identifier of a workflow execution.
	 */
	public Execution(final Timestamp eeStart, final Timestamp eeEnd, final Timestamp schedulerStart,
			final Timestamp schedulerEnd, final Timestamp portalStart, final Timestamp portalEnd,
			final int executionId) {
		this.eeStart = eeStart;
		this.eeEnd = eeEnd;
		this.schedulerStart = schedulerStart;
		this.schedulerEnd = schedulerEnd;
		this.portalStart = portalStart;
		this.portalEnd = portalEnd;
		this.executionId = executionId;
		this.beingLogged = true;
	}

	public Timestamp getEeStart() {
		return eeStart;
	}

	public Timestamp getEeEnd() {
		return eeEnd;
	}

	public Timestamp getSchedulerStart() {
		return schedulerStart;
	}

	public Timestamp getSchedulerEnd() {
		return schedulerEnd;
	}

	public Timestamp getPortalStart() {
		return portalStart;
	}

	public Timestamp getPortalEnd() {
		return portalEnd;
	}

	public boolean isBeingLogged() {
		return beingLogged;
	}

	/**
	 * Returns the execution ID of the execution. Throws an
	 * {@link IllegalStateException} in case the ID is not set. Use the
	 * isBeingLogged method to check whether to use this method.
	 * 
	 * @return the execution id of the method.
	 */
	public int getExecutionId() {
		if (beingLogged) {
			return executionId;
		} else {
			throw new IllegalStateException("Executions which are not logged don't have an Exec ID.");
		}
	}
}
