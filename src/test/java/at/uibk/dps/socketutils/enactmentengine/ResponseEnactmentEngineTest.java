package at.uibk.dps.socketutils.enactmentengine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;

import static org.mockito.Mockito.mock;

public class ResponseEnactmentEngineTest {

	/**
	 * Tests that the default constructor sets the attributed correctly.
	 */
	@Test
	public void testConstructor() {
		
		final JsonObject mockJson = mock(JsonObject.class);
		final int mockId = 1;
		final Statistics mockStats = mock(Statistics.class);
		
		ResponseEnactmentEngine tested = new ResponseEnactmentEngine(mockJson, mockId, mockStats);
		
		assertEquals(mockId, tested.getExecutionId());
		assertEquals(mockJson, tested.getWorkflowResult());
		assertEquals(mockStats, tested.getEnactmentEngineStatistics());
	}
}
