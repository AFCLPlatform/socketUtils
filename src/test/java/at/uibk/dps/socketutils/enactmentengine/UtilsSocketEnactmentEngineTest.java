package at.uibk.dps.socketutils.enactmentengine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;
import at.uibk.dps.socketutils.testconstants.ConstantsTestSocketUtils;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.Arrays;

public class UtilsSocketEnactmentEngineTest {

	/**
	 * Tests the request generation.
	 */
	@Test
	public void testResponse() {

		final JsonObject mockResult = mock(JsonObject.class);
		final int mockId = 1;
		final Statistics mockStats = mock(Statistics.class);

		ResponseEnactmentEngine result = UtilsSocketEnactmentEngine.generateResponse(mockResult, mockId, mockStats);

		assertEquals(mockId, result.getExecutionId());
		assertEquals(mockStats, result.getEnactmentEngineStatistics());
		assertEquals(mockResult, result.getWorkflowResult());
	}

	@Test
	public void testRequestNoInput() {
		final byte[] mockWf = new byte[2];
		final boolean logResMock = false;

		RequestEnactmentEngine result = UtilsSocketEnactmentEngine.generateRequest(mockWf, logResMock);
		assertFalse(result.isLogResults());
		assertTrue(Arrays.equals(mockWf, result.getWorkflow()));
	}

	@Test
	public void testRequestInput() {
		final byte[] mockWf = new byte[2];
		final boolean logResMock = false;
		final byte[] mockInput = new byte[3];

		RequestEnactmentEngine result = UtilsSocketEnactmentEngine.generateRequest(mockWf, mockInput, logResMock);
		assertFalse(result.isLogResults());
		assertTrue(Arrays.equals(mockWf, result.getWorkflow()));
		assertTrue(Arrays.equals(mockInput, mockInput));
	}

	@Test
	public void testRequestFileNoInput() {

		final String mockPath = ConstantsTestSocketUtils.filePathReadTestFile;
		final boolean logResMock = true;

		try {
			RequestEnactmentEngine result = UtilsSocketEnactmentEngine.generateRequest(mockPath, logResMock);
			assertTrue(result.isLogResults());
			assertTrue(Arrays.equals(ConstantsTestSocketUtils.expectedByteValue, result.getWorkflow()));
		} catch (IOException exc) {
			fail("IOException when checking testing EE request no input.");
		}

	}

	@Test
	public void testRequestFileInput() {

		final String mockPath = ConstantsTestSocketUtils.filePathReadTestFile;
		final boolean logResMock = true;
		final byte[] mockInput = { 1, 1 };

		try {
			RequestEnactmentEngine result = UtilsSocketEnactmentEngine.generateRequest(mockPath, mockInput, logResMock);
			assertTrue(result.isLogResults());
			assertTrue(Arrays.equals(ConstantsTestSocketUtils.expectedByteValue, result.getWorkflow()));
			assertTrue(Arrays.equals(mockInput, result.getWorkflowInput()));
		} catch (IOException exc) {
			fail("IOException when checking testing EE request no input.");
		}

	}

}
