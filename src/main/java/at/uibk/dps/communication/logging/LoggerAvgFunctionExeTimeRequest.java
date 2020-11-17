package at.uibk.dps.communication.logging;

public class LoggerAvgFunctionExeTimeRequest extends LoggerRequest {

	protected final String functionLink;

	protected LoggerAvgFunctionExeTimeRequest(String functionLink) {
		super(LoggerRequest.RequestType.GET_AVG_EXEC_TIME);
		this.functionLink = functionLink;
	}

	public String getFunctionLink() {
		return functionLink;
	}
}
