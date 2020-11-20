package at.uibk.dps.socketutils.logger;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.Execution;
import at.uibk.dps.socketutils.entity.Invocation;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsSocketLoggerTest {

	@Test
	public void testXIDReq() {
		RequestLoggerExecutionId result = UtilsSocketLogger.generateExecutionIdRequest();
		assertEquals(RequestLogger.RequestType.GET_EXECUTION_ID, result.getRequestType());
	}

	@Test
	public void testUdateReq() {
		Execution execMock = mock(Execution.class);
		int execId = 42;
		when(execMock.getExecutionId()).thenReturn(execId);
		RequestLoggerXLogsUpdate result = UtilsSocketLogger.generateRequestUpdateLog(execMock);
		assertEquals(execMock, result.getExecution());
		assertEquals(execId, result.getExecutionId());
	}

	@Test
	public void testFuncLogReq() {
		int execId = 42;
		RequestLoggerFunctionLog result = UtilsSocketLogger.generateRequestFunctionLog(execId);
		assertEquals(RequestLogger.RequestType.FUNCTION_LOG, result.getRequestType());
		assertEquals(execId, result.getExecutionId());
	}

	@Test
	public void testWriteInvocationReq() {
		Invocation mockInvocation = mock(Invocation.class);
		int executionId = 42;
		RequestLoggerInvocationWrite result = UtilsSocketLogger.generateRequestInvocationWrite(mockInvocation,
				executionId);
		assertEquals(RequestLogger.RequestType.INVOCATION_WRITE, result.getRequestType());
		assertEquals(mockInvocation, result.getInvocation());
		assertEquals(executionId, result.getExecutionId());
	}

	@Test
	public void testFuncXTimeAvgReq() {
		final String functionLink = "link";
		RequestLoggerFuncXTimeAvg result = UtilsSocketLogger.generateRequestFuncXTimeAvg(functionLink);
		assertEquals(functionLink, result.getFunctionLink());
		assertEquals(RequestLogger.RequestType.GET_AVG_EXEC_TIME, result.getRequestType());
	}

	@Test
	public void testResponse() {
		int execId = 42;
		BigDecimal avgXTime = mock(BigDecimal.class);
		Invocation invMock1 = mock(Invocation.class);
		Invocation invMock2 = mock(Invocation.class);
		List<Invocation> invocations = new ArrayList<>(Arrays.asList(invMock1, invMock2));
		ResponseLogger result = UtilsSocketLogger.generateResponse(execId, avgXTime, invocations);
		assertEquals(execId, result.getExecutionId());
		assertEquals(avgXTime, result.getAvgExecutionTime());
		assertEquals(invocations, result.getInvocations());
	}
}
