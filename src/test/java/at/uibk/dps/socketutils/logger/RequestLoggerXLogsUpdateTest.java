package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.Execution;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

public class RequestLoggerXLogsUpdateTest {

	@Test
	public void test() {
		Execution execMock = mock(Execution.class);
		int execId = 42;
		when(execMock.getExecutionId()).thenReturn(execId);
		RequestLoggerXLogsUpdate tested = new RequestLoggerXLogsUpdate(execMock);
		assertEquals(execMock, tested.getExecution());
		assertEquals(execId, tested.getExecutionId());
	}
}
