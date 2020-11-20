package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestLoggerExecutionIdTest {

	@Test
	public void test() {
		RequestLoggerExecutionId tested = new RequestLoggerExecutionId();
		assertEquals(RequestLogger.RequestType.GET_EXECUTION_ID, tested.getRequestType());
	}
}
