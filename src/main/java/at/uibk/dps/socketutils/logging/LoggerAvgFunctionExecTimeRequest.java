package at.uibk.dps.socketutils.logging;

public class LoggerAvgFunctionExecTimeRequest extends LoggerRequest {

	protected final String functionLink;

	protected LoggerAvgFunctionExecTimeRequest(final String functionLink) {
		super(LoggerRequest.RequestType.GET_AVG_EXEC_TIME);
		this.functionLink = functionLink;
	}

	public String getFunctionLink() {
		return functionLink;
	}
}
