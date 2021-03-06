package at.uibk.dps.socketutils.logger;

import java.math.BigDecimal;
import java.util.List;

import at.uibk.dps.socketutils.entity.Invocation;

/**
 * This class is used to define the response of the invocation log manager
 * module (sent to mapping annotator, AFCLPortal or enactment engine).
 *
 * @author stefanpedratscher
 */
public class ResponseLogger {

	/**
	 * Execution identifier.
	 */
	protected final int executionId;

	/**
	 * Average execution time.
	 */
	protected final BigDecimal avgExecutionTime;

	/**
	 * Invocations.
	 */
	protected final List<Invocation> invocations;

	/**
	 * Represents the response of the invocation log manager.
	 *
	 * @param executionId identifier of the workflow execution.
	 * @param avgExecutionTime average execution time.
	 * @param invocations of the base functions.
	 */
	public ResponseLogger(final int executionId, final BigDecimal avgExecutionTime,
			final List<Invocation> invocations) {
		this.executionId = executionId;
		this.avgExecutionTime = avgExecutionTime;
		this.invocations = invocations;
	}

	public int getExecutionId() {
		return executionId;
	}

	public BigDecimal getAvgExecutionTime() {
		return avgExecutionTime;
	}

	public List<Invocation> getInvocations() {
		return invocations;
	}
}
