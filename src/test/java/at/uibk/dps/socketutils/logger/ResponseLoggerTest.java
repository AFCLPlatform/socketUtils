package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.Invocation;

import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseLoggerTest {

	@Test
	public void test() {
		int execId = 42;
		BigDecimal avgXTime = mock(BigDecimal.class);
		Invocation invMock1 = mock(Invocation.class);
		Invocation invMock2 = mock(Invocation.class);
		List<Invocation> invocations = new ArrayList<>(Arrays.asList(invMock1, invMock2));
		ResponseLogger tested = new ResponseLogger(execId, avgXTime, invocations);
		assertEquals(execId, tested.getExecutionId());
		assertEquals(avgXTime, tested.getAvgExecutionTime());
		assertEquals(invocations, tested.getInvocations());
	}
}
