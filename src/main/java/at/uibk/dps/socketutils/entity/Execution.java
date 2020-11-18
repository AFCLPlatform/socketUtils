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
    private Timestamp eeStart;

    /**
     * End time of the enactment engine.
     */
    private Timestamp eeEnd;

    /**
     * Start time of the scheduler.
     */
    private Timestamp schedulerStart;

    /**
     * End time of the scheduler.
     */
    private Timestamp schedulerEnd;

    /**
     * Start time of the portal.
     */
    private Timestamp portalStart;

    /**
     * End time of the portal.
     */
    private Timestamp portalEnd;

    /**
     * Constructor for an execution.
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
    }

    /**
     * Getter and Setter
     */

    public Timestamp getEeStart() {
        return eeStart;
    }

    public void setEeStart(final Timestamp eeStart) {
        this.eeStart = eeStart;
    }

    public Timestamp getEeEnd() {
        return eeEnd;
    }

    public void setEeEnd(final Timestamp eeEnd) {
        this.eeEnd = eeEnd;
    }

    public Timestamp getSchedulerStart() {
        return schedulerStart;
    }

    public void setSchedulerStart(final Timestamp schedulerStart) {
        this.schedulerStart = schedulerStart;
    }

    public Timestamp getSchedulerEnd() {
        return schedulerEnd;
    }

    public void setSchedulerEnd(final Timestamp schedulerEnd) {
        this.schedulerEnd = schedulerEnd;
    }

    public Timestamp getPortalStart() {
        return portalStart;
    }

    public void setPortalStart(final Timestamp portalStart) {
        this.portalStart = portalStart;
    }

    public Timestamp getPortalEnd() {
        return portalEnd;
    }

    public void setPortalEnd(final Timestamp portalEnd) {
        this.portalEnd = portalEnd;
    }
}
