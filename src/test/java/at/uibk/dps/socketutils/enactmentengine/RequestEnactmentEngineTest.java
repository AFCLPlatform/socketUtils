package at.uibk.dps.socketutils.enactmentengine;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RequestEnactmentEngineTest {

	/**
	 * Tests that the default constructor sets the attributes correctly.
	 */
	@Test
	public void testConstructor() {
		final byte[] wf = new byte[2];
		wf[0] = 1;
		wf[1] = 2;
		final byte[] input = new byte[3];
		input[0] = 1;
		input[1] = 2;
		input[2] = 3;
		final boolean logResults = true;
		RequestEnactmentEngine tested = new RequestEnactmentEngine(wf, input, logResults);
		assertTrue(tested.isLogResults());
		assertNotEquals(wf, tested.getWorkflow());
		assertNotEquals(input, tested.getWorkflowInput());
		assertTrue(Arrays.equals(wf, tested.getWorkflow()));
		assertTrue(Arrays.equals(input, tested.getWorkflowInput()));
		assertTrue(tested.isExecutedWithInput());
	}

	/**
	 * Tests the missing input exception.
	 */
	@Test(expected = IllegalStateException.class)
	public void testConstructorNull() {
		final byte[] wf = new byte[2];
		wf[0] = 1;
		wf[1] = 2;
		final boolean logResults = true;
		RequestEnactmentEngine tested = new RequestEnactmentEngine(wf, logResults);
		assertTrue(tested.isLogResults());
		assertNotEquals(wf, tested.getWorkflow());
		assertTrue(Arrays.equals(wf, tested.getWorkflow()));
		assertFalse(tested.isExecutedWithInput());
		tested.getWorkflowInput();
	}
}
