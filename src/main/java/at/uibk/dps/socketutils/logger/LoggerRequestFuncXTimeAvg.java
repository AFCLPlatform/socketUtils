package at.uibk.dps.socketutils.logger;

public class LoggerRequestFuncXTimeAvg extends LoggerRequest {

	protected final String functionLink;

	protected LoggerRequestFuncXTimeAvg(final String functionLink) {
		super(LoggerRequest.RequestType.GET_AVG_EXEC_TIME);
		this.functionLink = functionLink;
	}

	public String getFunctionLink() {
		return functionLink;
	}
}
