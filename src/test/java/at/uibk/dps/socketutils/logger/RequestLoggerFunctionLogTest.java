package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestLoggerFunctionLogTest {

	@Test
	public void test() {
		int execId = 42;
		RequestLoggerFunctionLog tested = new RequestLoggerFunctionLog(execId);
		assertEquals(RequestLogger.RequestType.FUNCTION_LOG, tested.getRequestType());
		assertEquals(execId, tested.getExecutionId());
	}
}
