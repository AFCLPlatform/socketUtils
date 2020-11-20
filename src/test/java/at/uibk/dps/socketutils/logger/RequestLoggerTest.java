package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.logger.RequestLogger.RequestType;

import static org.mockito.Mockito.mock;

public class RequestLoggerTest {

	@Test
	public void test() {
		RequestType mockType = mock(RequestLogger.RequestType.class);
		RequestLogger tested = new RequestLogger(mockType);
		assertEquals(mockType, tested.getRequestType());
	}
}
