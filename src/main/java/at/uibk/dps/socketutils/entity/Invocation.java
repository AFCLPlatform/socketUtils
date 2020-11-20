package at.uibk.dps.socketutils.entity;

import java.sql.Timestamp;

/**
 * Represents an invocation of a cloud function.
 *
 * @author stefanpedratscher
 */
public class Invocation {

	/**
	 * Function resource link to invoke.
	 */
	protected final String functionLink;

	/**
	 * Provider on which the cloud function is invoked.
	 */
	protected final String provider;

	/**
	 * Region in which the cloud function is invoked.
	 */
	protected final String region;

	/**
	 * Invocation time of the cloud function.
	 */
	protected final Timestamp invokeTime;

	/**
	 * Response time of the cloud function.
	 */
	protected final Timestamp returnTime;

	/**
	 * Actual execution time in ms of the cloud function.
	 */
	protected final long executionTime;

	/**
	 * Exit status of the cloud function. OK or ERROR.
	 */
	protected final String status;

	/**
	 * The error message if an error occured.
	 */
	protected final String errorMessage;

	/**
	 * Execution identifier to which the cloud function belongs.
	 */
	protected final int executionId;

	/**
	 * Constructor for an invocation.
	 *
	 * @param functionLink  resource link to invoke.
	 * @param provider      on which the cloud function is invoked.
	 * @param region        in which the cloud function is invoked.
	 * @param invokeTime    of the cloud function.
	 * @param returnTime    of the cloud function.
	 * @param executionTime in ms of the cloud function.
	 * @param status        exit status of the cloud function. OK or ERROR.
	 * @param errorMessage  if an error occured.
	 * @param executionId   identifier to which the cloud function belongs.
	 */
	public Invocation(final String functionLink, final String provider, final String region, final Timestamp invokeTime,
			final Timestamp returnTime, final long executionTime, final String status, final String errorMessage,
			final int executionId) {
		this.functionLink = functionLink;
		this.provider = provider;
		this.region = region;
		this.invokeTime = invokeTime;
		this.returnTime = returnTime;
		this.executionTime = executionTime;
		this.status = status;
		this.errorMessage = errorMessage;
		this.executionId = executionId;
	}

	public String getFunctionLink() {
		return functionLink;
	}

	public String getProvider() {
		return provider;
	}

	public String getRegion() {
		return region;
	}

	public Timestamp getInvokeTime() {
		return invokeTime;
	}

	public Timestamp getReturnTime() {
		return returnTime;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getExecutionId() {
		return executionId;
	}
}
