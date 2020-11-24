package at.uibk.dps.socketutils.scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;

import static org.mockito.Mockito.mock;

public class ResponseSchedulerTest {

	@Test
	public void test() {
		JsonObject resultMock = mock(JsonObject.class);
		int execId = 1;
		Statistics eeStatsMock = mock(Statistics.class);
		Statistics schedStatsMock = mock(Statistics.class);
		ResponseScheduler tested = new ResponseScheduler(resultMock, execId, eeStatsMock, schedStatsMock);
		assertEquals(execId, tested.getExecutionId());
		assertEquals(resultMock, tested.getWorkflowResult());
		assertEquals(eeStatsMock, tested.getEnactmentEngineStatistics());
		assertEquals(schedStatsMock, tested.getSchedulerStatistics());
	}
}
