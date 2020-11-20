package at.uibk.dps.socketutils.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

public class InvocationTest {

	@Test
	public void test() {
		final String funcLinkMock = "function";
		final String providerMock = "amazon";
		final String regionMock = "NA";
		final Timestamp invTimeMock = mock(Timestamp.class);
		final Timestamp retTimeMock = mock(Timestamp.class);
		final long execTimeMock = 42;
		final String statusMock = "ok";
		final String errorMock = "not ok";
		final int execIdMock = 3;

		Invocation tested = new Invocation(funcLinkMock, providerMock, regionMock, invTimeMock, retTimeMock,
				execTimeMock, statusMock, errorMock, execIdMock);
		assertEquals(funcLinkMock, tested.getFunctionLink());
		assertEquals(providerMock, tested.getProvider());
		assertEquals(regionMock, tested.getRegion());
		assertEquals(invTimeMock, tested.getInvokeTime());
		assertEquals(retTimeMock, tested.getReturnTime());
		assertEquals(execTimeMock, tested.getExecutionTime());
		assertEquals(statusMock, tested.getStatus());
		assertEquals(errorMock, tested.getErrorMessage());
		assertEquals(execIdMock, tested.getExecutionId());
	}
}
