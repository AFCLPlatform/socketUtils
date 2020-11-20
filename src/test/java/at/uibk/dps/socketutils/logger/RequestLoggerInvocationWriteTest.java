package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.Invocation;

import static org.mockito.Mockito.mock;

public class RequestLoggerInvocationWriteTest {

	@Test
	public void test() {
		Invocation mockInvocation = mock(Invocation.class);
		int executionId = 42;
		RequestLoggerInvocationWrite tested = new RequestLoggerInvocationWrite(mockInvocation, executionId);
		assertEquals(RequestLogger.RequestType.INVOCATION_WRITE, tested.getRequestType());
		assertEquals(mockInvocation, tested.getInvocation());
		assertEquals(executionId, tested.getExecutionId());
	}
}
