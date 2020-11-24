package at.uibk.dps.socketutils.scheduler;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RequestSchedulerTest {

	@Test
	public void testAllParams() {
		byte[] wf = {1,2};
		byte[] schedConfig = {2,3};
		byte[] input = {4,5};
		RequestScheduler tested = new RequestScheduler(wf, input, schedConfig);
		assertTrue(Arrays.equals(wf, tested.getWorkflow()));
		assertTrue(Arrays.equals(schedConfig, tested.getSchedulerConfig()));
		assertTrue(Arrays.equals(input, tested.getWorkflowInput()));
		assertTrue(tested.isScheduleConfigSet());
		assertTrue(tested.isWorkFlowInputSet());
	}

	@Test(expected = IllegalStateException.class)
	public void testOnlyWfOne(){
		byte[] wf = {1,2};
		RequestScheduler tested = new RequestScheduler(wf);
		assertTrue(Arrays.equals(wf, tested.getWorkflow()));
		assertFalse(tested.isScheduleConfigSet());
		assertFalse(tested.isWorkFlowInputSet());
		tested.getSchedulerConfig();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testOnlyWfTwo(){
		byte[] wf = {1,2};
		RequestScheduler tested = new RequestScheduler(wf);
		assertTrue(Arrays.equals(wf, tested.getWorkflow()));
		assertFalse(tested.isScheduleConfigSet());
		assertFalse(tested.isWorkFlowInputSet());
		tested.getWorkflowInput();
	}
}
