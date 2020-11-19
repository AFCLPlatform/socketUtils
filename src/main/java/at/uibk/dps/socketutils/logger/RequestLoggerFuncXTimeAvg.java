package at.uibk.dps.socketutils.logger;

/**
 * The {@link RequestLoggerFuncXTimeAvg} request is used to
 * get the average function execution time.
 *
 * @author stefanpedratscher
 */
public class RequestLoggerFuncXTimeAvg extends RequestLogger {

	/**
	 * The resource of the function.
	 */
	protected final String functionLink;

	/**
	 * Request average execution time of a base function.
	 *
	 * @param functionLink resource of the function.
	 */
	protected RequestLoggerFuncXTimeAvg(final String functionLink) {
		super(RequestLogger.RequestType.GET_AVG_EXEC_TIME);
		this.functionLink = functionLink;
	}

	public String getFunctionLink() {
		return functionLink;
	}
}
