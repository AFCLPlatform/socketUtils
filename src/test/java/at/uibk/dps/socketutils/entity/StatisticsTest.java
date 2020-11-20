package at.uibk.dps.socketutils.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

public class StatisticsTest {

	@Test
	public void test() {
		Timestamp startMock = mock(Timestamp.class);
		Timestamp endMock = mock(Timestamp.class);

		Statistics tested = new Statistics(startMock, endMock);
		assertEquals(startMock, tested.getStart());
		assertEquals(endMock, tested.getEnd());
	}
}
