package at.uibk.dps.socketutils.logger;

public class RequestLoggerFuncXTimeAvg extends RequestLogger {

	protected final String functionLink;

	protected RequestLoggerFuncXTimeAvg(final String functionLink) {
		super(RequestLogger.RequestType.GET_AVG_EXEC_TIME);
		this.functionLink = functionLink;
	}

	public String getFunctionLink() {
		return functionLink;
	}
}
