package at.uibk.dps.communication;

import at.uibk.dps.communication.entity.Invocation;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class is used to define the response of the invocation log manager
 * module (sent to mapping annotator, AFCLPortal or enactment engine).
 *
 * @author stefanpedratscher
 */
public class InvocationLogManagerResponse {

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

	public InvocationLogManagerResponse(final int executionId, final BigDecimal avgExecutionTime,
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
