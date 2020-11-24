package at.uibk.dps.socketutils.scheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;
import at.uibk.dps.socketutils.testconstants.ConstantsTestSocketUtils;

public class UtilsSocketSchedulerTest {

	@Test
	public void testResponse() {
		JsonObject resultMock = mock(JsonObject.class);
		int execId = 1;
		Statistics eeStatsMock = mock(Statistics.class);
		Statistics schedStatsMock = mock(Statistics.class);
		ResponseScheduler result = UtilsSocketScheduler.generateResponse(resultMock, execId, eeStatsMock,
				schedStatsMock);
		assertEquals(execId, result.getExecutionId());
		assertEquals(resultMock, result.getWorkflowResult());
		assertEquals(eeStatsMock, result.getEnactmentEngineStatistics());
		assertEquals(schedStatsMock, result.getSchedulerStatistics());
	}

	@Test
	public void testReqLocalFile() {
		try {
			RequestScheduler result = UtilsSocketScheduler
					.generateRequest(ConstantsTestSocketUtils.filePathReadTestFile);
			assertTrue(Arrays.equals(ConstantsTestSocketUtils.expectedByteValue, result.getWorkflow()));
		} catch (IOException ioExc) {
			fail("IOException when testing schedule request generation from file.");
		}
	}

	@Test
	public void testReqNoInput() {
		byte[] wf = { 1, 2 };
		byte[] schedConfig = { 2, 3 };
		RequestScheduler result = UtilsSocketScheduler.generateRequest(wf, schedConfig);
		assertTrue(Arrays.equals(wf, result.getWorkflow()));
		assertTrue(Arrays.equals(schedConfig, result.getSchedulerConfig()));
		assertTrue(result.isScheduleConfigSet());
		assertFalse(result.isWorkFlowInputSet());
	}

	@Test
	public void testReqAllParams() {
		byte[] wf = { 1, 2 };
		byte[] schedConfig = { 2, 3 };
		byte[] input = { 4, 5 };
		RequestScheduler result = UtilsSocketScheduler.generateRequest(wf, input, schedConfig);
		assertTrue(Arrays.equals(wf, result.getWorkflow()));
		assertTrue(Arrays.equals(schedConfig, result.getSchedulerConfig()));
		assertTrue(Arrays.equals(input, result.getWorkflowInput()));
		assertTrue(result.isScheduleConfigSet());
		assertTrue(result.isWorkFlowInputSet());
	}

	@Test
	public void testReqOnlyWf() {
		byte[] wf = { 1, 2 };
		RequestScheduler result = UtilsSocketScheduler.generateRequest(wf);
		assertTrue(Arrays.equals(wf, result.getWorkflow()));
		assertFalse(result.isScheduleConfigSet());
		assertFalse(result.isWorkFlowInputSet());
	}

}
