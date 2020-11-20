package at.uibk.dps.socketutils.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

public class ExecutionTest {

	/**
	 * Test for an execution which is logged
	 */
	@Test
	public void testLogged() {
		Timestamp mockEEStart = mock(Timestamp.class);
		Timestamp mockEEEnd = mock(Timestamp.class);
		Timestamp mockSStart = mock(Timestamp.class);
		Timestamp mockSEnd = mock(Timestamp.class);
		Timestamp mockPStart = mock(Timestamp.class);
		Timestamp mockPEnd = mock(Timestamp.class);
		int mockId = 42;
		
		Execution tested = new Execution(mockEEStart, mockEEEnd, mockSStart, mockSEnd, mockPStart, mockPEnd, mockId);
		
		assertEquals(mockEEStart, tested.getEeStart());
		assertEquals(mockEEEnd, tested.getEeEnd());
		assertEquals(mockSStart, tested.getSchedulerStart());
		assertEquals(mockSEnd, tested.getSchedulerEnd());
		assertEquals(mockPStart, tested.getPortalStart());
		assertEquals(mockPEnd, tested.getPortalEnd());
		assertTrue(tested.isBeingLogged());
		assertEquals(mockId, tested.getExecutionId());
	}
	
	/**
	 * Test for an execution which is not logged.
	 */
	@Test(expected = IllegalStateException.class)
	public void testNotLogged() {
		Timestamp mockEEStart = mock(Timestamp.class);
		Timestamp mockEEEnd = mock(Timestamp.class);
		Timestamp mockSStart = mock(Timestamp.class);
		Timestamp mockSEnd = mock(Timestamp.class);
		Timestamp mockPStart = mock(Timestamp.class);
		Timestamp mockPEnd = mock(Timestamp.class);
		
		Execution tested = new Execution(mockEEStart, mockEEEnd, mockSStart, mockSEnd, mockPStart, mockPEnd);
		
		assertEquals(mockEEStart, tested.getEeStart());
		assertEquals(mockEEEnd, tested.getEeEnd());
		assertEquals(mockSStart, tested.getSchedulerStart());
		assertEquals(mockSEnd, tested.getSchedulerEnd());
		assertEquals(mockPStart, tested.getPortalStart());
		assertEquals(mockPEnd, tested.getPortalEnd());
		assertFalse(tested.isBeingLogged());
		tested.getExecutionId();
	}
}
