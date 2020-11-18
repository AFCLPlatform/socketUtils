package at.uibk.dps.socketutils.entity;

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
	protected final Timestamp start;

	/**
	 * The end time of the module.
	 */
	protected final Timestamp end;

	/**
	 * Default constructor for module statistics.
	 *
	 * @param start time of the module.
	 * @param end   time of the module.
	 */
	public Statistics(final Timestamp start, final Timestamp end) {
		this.start = start;
		this.end = end;
	}

	public Timestamp getStart() {
		return start;
	}

	public Timestamp getEnd() {
		return end;
	}
}
