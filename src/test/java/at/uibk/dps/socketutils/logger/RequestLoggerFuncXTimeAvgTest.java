package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestLoggerFuncXTimeAvgTest {

	@Test
	public void test() {
		final String functionLink = "link";
		RequestLoggerFuncXTimeAvg tested = new RequestLoggerFuncXTimeAvg(functionLink);
		assertEquals(functionLink, tested.getFunctionLink());
		assertEquals(RequestLogger.RequestType.GET_AVG_EXEC_TIME, tested.getRequestType());
	}
}
