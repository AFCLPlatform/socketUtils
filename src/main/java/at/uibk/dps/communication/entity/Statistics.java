package at.uibk.dps.communication.entity;

import java.sql.Timestamp;

/**
 * Statistics for several modules.
 *
 * @author stefanpedratscher
 */
public class Statistics {

    /**
     * The start time of the module.
     */
    private Timestamp start;

    /**
     * The end time of the module.
     */
    private Timestamp end;

    /**
     * Default constructor for module statistics.
     *
     * @param start time of the module.
     * @param end time of the module.
     */
    public Statistics(Timestamp start, Timestamp end) {
        this.start = start;
        this.end = end;
    }

    /** Getter and Setter */

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
